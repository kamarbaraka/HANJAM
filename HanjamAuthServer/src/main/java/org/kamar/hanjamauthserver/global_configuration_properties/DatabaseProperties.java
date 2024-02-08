package org.kamar.hanjamauthserver.global_configuration_properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Represents the configuration properties for the database.
 * These properties can be retrieved using the {@link ConfigurationProperties} annotation.
 *
 * <p>
 * The properties include the database URL, username, and password.
 * </p>
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@ConfigurationProperties(prefix = "app.db")
public record DatabaseProperties(
        String url,
        String schema,
        String user,
        String password
) {
}
