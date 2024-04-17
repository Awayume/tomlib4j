// SPDX-FileCopyrightText: 2024 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.tomlib4j.toml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import java.lang.reflect.Field;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.errorprone.annotations.DoNotCall;

import jp.awayume.tomlib4j.annotations.NotKey;
import jp.awayume.tomlib4j.annotations.Table;


/**
 * A class for parsing and retaining TOML data whose structure is known.
 *
 * @author Awayume {@literal <dev@awayume.jp>}
 * @since 0.1
 */
public abstract class TOML {
    /**
     * Parses TOML from file.
     *
     * @param path The path of the TOML file
     */
    public TOML(Path path) throws IOException {
        this(path.toFile());
    }

    /**
     * Parses TOML from {@link File} instance.
     *
     * @param file The {@link File} instance
     */
    @SuppressWarnings("method.invocation")
    public TOML(File file) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        this.parseLines(lines.toArray(new String[0]));
    }

    /**
     * Parses TOML from string.
     *
     * @param data The String of TOML data
     */
    @SuppressWarnings("method.invocation")
    public TOML(String data) {
        this.parseLines(data.split("\r?\n"));
    }

    /**
     * Parses TOML from strings splitted by lines.
     *
     * @param lines Strings of TOML data split by lines
     */
    private void parseLines(String[] lines) {
        Map<String, Field> keyFields = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.getAnnotation(NotKey.class) == null) {
                Table table = field.getAnnotation(Table.class);
                if (table != null) {
                    keyFields.put(String.format("%s.%s", table.name(), field.getName()), field);
                } else {
                    keyFields.put(field.getName(), field);
                }
            }
        }
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.equals("")) {
                continue;
            }
            else if (!line.startsWith("#")) {
                if (line.startsWith("\\[(\\w|-)+\\]")) {
                    // TODO
                } else if (line.startsWith("(\\w|-)+")) {
                    String[] pair = line.split("\\s*=\\s*", 2);
                    if (pair.length != 2 || pair[1].length() == 0) {
                        throw new RuntimeException("Invalid syntax");
                    }
                    String key = pair[0];
                    String value = pair[1];
                    // TODO
                } else if (line.startsWith("\".*\"")) {
                    int keyLength = 0;
                    boolean isEscaped = false;
                    for (int j = 1; j < line.length(); j++) {
                        char ch = line.charAt(j);
                        if (ch == '\\') {
                            isEscaped = true;
                        } else if (!isEscaped && ch == '"') {
                            keyLength = j + 1;
                        } else if (isEscaped) {
                            isEscaped = false;
                        }
                    }
                    if (keyLength == 0) {
                        throw new RuntimeException("Invalid syntax");
                    }
                    String key = line.substring(1, keyLength);
                    String value = line.substring(keyLength + 1).split("\\s*=\\s*", 2)[1].trim();
                    if (value.length() == 0) {
                        throw new RuntimeException("Invalid syntax");
                    }
                    // TODO
                } else {
                    throw new RuntimeException("Invalid syntax");
                }
            }
        }
    }

    /**
     * Saves TOML data to file.
     *
     * @param path The path of the file to save TOML data
     */
    @DoNotCall
    public final void toFile(Path path) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Writes TOML data to {@link File} instance.
     *
     * @param file The {@link File} instance
     */
    @DoNotCall
    public final void toFile(File file) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Returns the string of TOML data.
     *
     * @return The string of TOML data
     */
    @DoNotCall
    @Override
    public final String toString() {
        throw new UnsupportedOperationException("Not implemented");
    }
}

