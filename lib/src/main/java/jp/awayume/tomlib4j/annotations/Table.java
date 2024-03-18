// SPDX-FileCopyrightText: 2024 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.tomlib4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * A marker annotation to specify the table of TOML.
 *
 *
 * Usage:
 *
 * <pre><code>
 * import jp.awayume.tomlib4j.toml.TOML;
 * import jp.awayume.tomlib4j.annotations.Table;
 *
 * public class MyTOML extends TOML {
 *     {@literal @}Table("user")
 *     public String name;
 *     {@literal @}Table("user.config")
 *     public boolean active;
 * }
 * </code></pre>
 *
 * <pre><code>
 * [user]
 * name = "Awayume"
 *
 * [user.config]
 * active = true
 * </code></pre>
 *
 * @author Awayue {@literal <dev@awayume.jp>}
 * @since 0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Table {
    /**
     * The table name of TOML.
     */
    String name();
}
