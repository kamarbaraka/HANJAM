package org.kamar.hanjamauthserver.global_api_doc;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;


/**
 * This class represents the global API documentation for the Hanjam Authorization Server.
 * It provides information about the server, its version, licenses, contacts, tags, and security schemes.
 * This class is annotated with the necessary annotations to generate OpenAPI documentation.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@RestController
@OpenAPIDefinition(
        info = @Info(
                title = "Hanjam Authorization Server",
                description = "The authorization server for the **Hanjam** application.",
                summary = "Hanjam authorization server.",
                termsOfService = "",
                version = "v0.0.1",
                license = @License(
                        name = "MIT",
                        url = "",
                        identifier = "MIT"
                ),
                contact = @Contact(
                        name = "samson baraka",
                        email = "kamar254baraka@gmail.com",
                        url = "https://github.com/kamarbaraka"
                )
        ),
        tags = {
                @Tag(name = "User Management." , description = "Apis for ``managing`` users of the system." ),
                @Tag(name = "Client Management.", description = "Apis for managing client applications.")
        }
//        servers = {},
        /*security = {
                @SecurityRequirement(name = "oauth2")
        }*/
)
/*@SecurityScheme(
        type = SecuritySchemeType.OAUTH2,
        name = "oauth2",
        description = "",
        flows = @OAuthFlows(
                authorizationCode = @OAuthFlow(
                        authorizationUrl = "",
                        tokenUrl = "",
                        refreshUrl = "",
                        scopes = {}
                )
        ),
        openIdConnectUrl = "",
        ref = ""
)*/

public class GlobalApiDocumentation {
}
