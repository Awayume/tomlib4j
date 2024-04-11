// SPDX-FileCopyrightText: 2024 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.tomlib4j.toml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.errorprone.annotations.DoNotCall;


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
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            // TODO
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

