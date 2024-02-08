package org.kamar.hanjamauthserver.client_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * The RegisteredClientEntity class represents a registered client entity in the system.
 *
 * <p>Registered client entities are used for client registration and authentication in OAuth 2.0 and OpenID Connect protocols.
 * This class provides the necessary properties and methods to configure and manage a registered client.</p>
 *
 * <p>This class extends the Object class and inherits its methods. It also contains additional fields and methods specific
 * to the registered client entity.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     RegisteredClientEntity clientEntity = new RegisteredClientEntity();
 *     clientEntity.setClientName("Sample Client");
 *     clientEntity.setRedirectUri("https://example.com/callback");
 *     // ... other property configurations
 * </pre>
 *
 * <p><b>Fields:</b></p>
 * <ul>
 *     <li>{@code randomUUID}: A transient field holding a randomly generated UUID for internal use.</li>
 *     <li>{@code id}: A UUID field representing the unique identifier of the registered client entity.</li>
 *     <li>{@code clientName}: A String field representing the name of the registered client.</li>
 *     <li>{@code clientId}: A final String field representing the client ID generated based on the randomUUID field.</li>
 *     <li>{@code clientSecret}: A String field representing the client secret generated based on the randomUUID field.</li>
 *     <li>{@code clientIssuedAt}: An Instant field representing the timestamp when the client was issued.</li>
 *     <li>{@code clientSecretExpiresAt}: An Instant field representing the expiration timestamp of the client secret.</li>
 *     <li>{@code redirectUri}: A String field representing the URI to redirect after successful authorization.</li>
 *     <li>{@code postLogoutRedirectUri}: A String field representing the URI to redirect after logout.</li>
 *     <li>{@code scopes}: A Set of Strings representing the scopes authorized for the client.</li>
 *     <li>{@code clientAuthenticationMethods}: A Set of ClientAuthenticationMethod enum values representing the supported client authentication methods.</li>
 *     <li>{@code authorizationGrantTypes}: A Set of AuthorizationGrantType enum values representing the supported authorization grant types.</li>
 *     <li>{@code clientSettings}: A ClientSettings object representing the settings for client authorization consent.</li>
 *     <li>{@code tokenSettings}: A TokenSettings object representing the settings for token generation and validation.</li>
 *     <li>{@code updatedOn}: An Instant field representing the timestamp when the client entity was last updated.</li>
 * </ul>
 *
 * <p><b>Methods:</b></p>
 * <ul>
 *     <li>{@code configureClientSettings()}: A private method that configures the client settings for authorization consent.
 *     It returns a ClientSettings object with authorization consent enabled.</li>
 *     <li>{@code configureTokenSettings()}: A private method that configures the token settings for token generation and validation.
 *     It returns a TokenSettings object with the specified settings.</li>
 * </ul>
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Getter
@Setter
@Entity(name = "registered_clients")
public class RegisteredClientEntity {

    @Id
    @Column(name = "id", nullable = false)
    private final String  id = UUID.randomUUID().toString();

    @NotBlank(message = "client name cannot be blank.")
    @NotEmpty(message = "client name cannot be empty.")
    @NotNull(message = "client name cannot be null.")
    @Column(nullable = false)
    private String clientName;

    @NotBlank(message = "client ID cannot be blank.")
    @NotEmpty(message = "client ID cannot be empty.")
    @NotNull(message = "client ID cannot be null.")
    @Column(nullable = false, unique = true)
    private final String clientId = UUID.randomUUID().toString();

    @NotBlank(message = "client secret cannot be blank.")
    @NotEmpty(message = "client secret cannot be empty.")
    @NotNull(message = "client secret cannot be null.")
    @Column(nullable = false)
    private String clientSecret = UUID.randomUUID().toString();

    @NotNull(message = "client issued at cannot be null.")
    @Column(nullable = false)
    private final Instant clientIssuedAt = Instant.now();

    private Instant clientSecretExpiresAt;

    @NotBlank(message = "redirect uri cannot be blank.")
    @NotEmpty(message = "redirect uri cannot be empty.")
    @NotNull(message = "redirect uri cannot be null.")
    @Column(nullable = false)
    private String redirectUri;

    @NotBlank(message = "post logout redirect uri cannot be blank.")
    @NotEmpty(message = "post logout redirect uri cannot be empty.")
    @NotNull(message = "post logout redirect uri cannot be null.")
    @Column(nullable = false)
    private String postLogoutRedirectUri;

    @NotBlank(message = "scope cannot be blank.")
    @NotEmpty(message = "scope cannot be empty.")
    @NotNull(message = "scope cannot be null.")
    @ElementCollection
    @Column(name = "scope")
    @CollectionTable(name = "registered_clients_scopes", joinColumns = @JoinColumn(name = "registred_client_id"))
    private final Set<String> scopes = new LinkedHashSet<>();

    @NotNull(message = "client authentication method cannot be null")
    @ElementCollection
    @Column(name = "client_authentication_method", nullable = false)
    @CollectionTable(name = "registered_clients_clientAuthenticationMethods", joinColumns = @JoinColumn(name = "owner_id"))
    private final Set<ClientAuthenticationMethod> clientAuthenticationMethods = new LinkedHashSet<>(
            List.of(
                    ClientAuthenticationMethod.CLIENT_SECRET_BASIC,
                    ClientAuthenticationMethod.CLIENT_SECRET_POST
            )
    );

    @NotNull(message = "authorization grant type cannot be null.")
    @ElementCollection
    @Column(name = "authorization_grant_type", nullable = false)
    @CollectionTable(name = "registered_clients_authorizationGrantTypes", joinColumns = @JoinColumn(name = "registered_client_id"))
    private Set<AuthorizationGrantType> authorizationGrantTypes = new LinkedHashSet<>(
            List.of(AuthorizationGrantType.AUTHORIZATION_CODE, AuthorizationGrantType.REFRESH_TOKEN)
    );

    @NotNull(message = "client settings cannot be null.")
    @Column(name = "client_settings", nullable = false)
    private final ClientSettings clientSettings = configureClientSettings();

    @NotNull(message = "token settings cannot be null.")
    @Column(name = "token_settings", nullable = false)
    private final TokenSettings tokenSettings = configureTokenSettings();

    @NotNull(message = "updated on cannot be null.")
    @Column(nullable = false)
    private Instant updatedOn = Instant.now();

    /**
     * Configures the client settings for authorization consent.
     *
     * @return The configured ClientSettings object with authorization consent enabled.
     */
    private ClientSettings configureClientSettings(){

        /*enable authorization consent*/
        return ClientSettings
                .builder()
                .requireAuthorizationConsent(true)
                .build();
    }

    /**
     * Configures the token settings for token generation and validation.
     *
     * @return The configured TokenSettings object.
     */
    private TokenSettings configureTokenSettings(){

        /*set the duration for the tokens to live*/
        Duration duration = Duration.ofMinutes(10);
        /*configure the settings*/
        return TokenSettings
                .builder()
                .accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
                .accessTokenTimeToLive(duration)
                .authorizationCodeTimeToLive(duration)
                .deviceCodeTimeToLive(duration)
                .idTokenSignatureAlgorithm(SignatureAlgorithm.ES512)
                .build();
    }

}