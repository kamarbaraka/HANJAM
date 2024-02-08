package org.kamar.hanjamauthserver.global_configuration;


import org.kamar.hanjamauthserver.global_configuration_properties.DatabaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This class represents the configuration for the global properties in the application.
 * It is annotated with {@code @Configuration} to indicate that it is a configuration class.
 * The {@code @EnableConfigurationProperties} annotation is used to enable configuration properties.
 *
 * <p>
 * The class is responsible for enabling and providing configuration properties for the application.
 * It specifically enables and provides {@link DatabaseProperties} as a configuration property.
 * </p>
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Configuration
@EnableConfigurationProperties({
        DatabaseProperties.class
})
public class GlobalConfigurationPropertiesConfiguration {
}
