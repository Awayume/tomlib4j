// SPDX-FileCopyrightText: 2024 Awayume <dev@awayume.jp>
// SPDX-License-Identifier: Apache-2.0

package jp.awayume.tomlib4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * A marker annotation to indicate that the field is not part of the TOML data.
 *
 * Usage:
 *
 * <pre><code>
 * import jp.awayume.tomlib4j.toml.TOML;
 * import jp.awayume.tomlib4j.annotations.NotKey;
 *
 * public class MyTOML extends TOML {
 *     public String name;
 *     {@literal @}NotKey
 *     private Logger logger;
 * }
 * </code></pre>
 *
 * <pre><code>
 * name = "Awayume"
 * </code></pre>
 *
 * @author Awayume {@literal <dev@awayume.jp>}
 * @since 0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface NotKey {}
