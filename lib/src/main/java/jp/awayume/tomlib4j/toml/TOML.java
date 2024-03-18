// SPDX-FileCopyrightText: 2024 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.tomlib4j.toml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

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
    public TOML(Path path) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Parses TOML from {@link File} instance.
     *
     * @param file The {@link File} instance
     */
    public TOML(File file) {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Parses TOML from string.
     *
     * @param data The TOML data string
     */
    public TOML(String data) {
        throw new UnsupportedOperationException("Not implemented");
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

