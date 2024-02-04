package org.kamar.hanjamauthserver.global_configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class is the global general configuration for the application.
 * It is annotated with @Configuration, enabling it to be used as a configuration class.
 * It enables transaction management, method security, and hypermedia support.
 * It also enables configuration properties to be used.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Configuration
/*enable transaction management*/
@EnableTransactionManagement
@EnableMethodSecurity
@EnableHypermediaSupport(type = {
        EnableHypermediaSupport.HypermediaType.HAL,
        EnableHypermediaSupport.HypermediaType.HAL_FORMS,
        EnableHypermediaSupport.HypermediaType.UBER,
        EnableHypermediaSupport.HypermediaType.COLLECTION_JSON,
        EnableHypermediaSupport.HypermediaType.HTTP_PROBLEM_DETAILS
})
@EnableConfigurationProperties
public class GlobalGeneralConfiguration {
}
