package org.kamar.hanjamauthserver.client_management.services;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.kamar.hanjamauthserver.client_management.dtos.RegisteredClientEntityDto;
import org.kamar.hanjamauthserver.client_management.entities.RegisteredClientEntity;
import org.kamar.hanjamauthserver.client_management.models.RegisteredClientEntityModel;
import org.kamar.hanjamauthserver.client_management.repositories.RegisteredClientEntityRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


/**
 * The RegisteredClientEntityManagementService class provides methods for managing registered clients.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Service
@RequiredArgsConstructor
public class RegisteredClientEntityManagementService implements RegisteredClientRepository {

    private final RegisteredClientEntityRepository registeredClientRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisteredClientEntityModelAssembler modelAssembler;

    /**
     * Registers a client by creating a new RegisteredClientEntity based on the provided DTO.
     *
     * @param dto The RegisteredClientEntityDto containing the client information.
     * @return The RegisteredClientEntityModel representing the registered client.
     * @throws NullPointerException if dto is null.
     */
    @NotNull
    public RegisteredClientEntityModel registerClient(@NotNull RegisteredClientEntityDto dto){

        /*create the entity from the dto.*/
        RegisteredClientEntity entity = new RegisteredClientEntity();
        entity.setClientName(dto.clientName());
        entity.setRedirectUri(dto.redirectUri());
        entity.setPostLogoutRedirectUri(dto.postLogoutRedirectUri());
        entity.getScopes().addAll(dto.scopes());

        /*convert to model*/
        RegisteredClientEntityModel model = modelAssembler.toModel(entity);

        /*encode the password*/
        entity.setClientSecret(passwordEncoder.encode(entity.getClientSecret()));

        /*persist*/
        registeredClientRepository.save(entity);

        /*return the model*/
        return model;

    }

    /**
     * Converts a RegisteredClientEntity object to a RegisteredClient object.
     *
     * @param entity The RegisteredClientEntity to convert.
     * @return The corresponding RegisteredClient object.
     */
    @NotNull
    private RegisteredClient entityToRegisteredClient(@NotNull RegisteredClientEntity entity){

        /*crete a registered client from the entity*/
        return RegisteredClient
                .withId(entity.getId())
                .clientName(entity.getClientName())
                .clientId(entity.getClientId())
                .clientSecret(entity.getClientSecret())
                .redirectUri(entity.getRedirectUri())
                .postLogoutRedirectUri(entity.getPostLogoutRedirectUri())
                .clientIdIssuedAt(entity.getClientIssuedAt())
                .scopes(scopes -> scopes.addAll(entity.getScopes()))
                .authorizationGrantTypes(grantTypes -> grantTypes.addAll(entity.getAuthorizationGrantTypes()))
                .clientAuthenticationMethods(authenticationMethods ->
                        authenticationMethods.addAll(entity.getClientAuthenticationMethods()))
                .clientSettings(entity.getClientSettings())
                .tokenSettings(entity.getTokenSettings())
                .build();
    }
    @Override
    public void save(RegisteredClient registeredClient) {

    }

    /**
     * Finds a registered client by ID.
     *
     * @param id The ID of the registered client to find.
     * @return The registered client with the specified ID.
     * @throws NoSuchElementException If no registered client is found with the given ID.
     */
    @Override
    public RegisteredClient findById(String id) {

        /*get the client with the ID*/
        RegisteredClientEntity entity = registeredClientRepository
                .findById(id)
                .orElseThrow();
        /*convert to a registered client*/
        return entityToRegisteredClient(entity);
    }

    /**
     * Find a registered client by client ID.
     *
     * @param clientId The client ID of the registered client to find.
     * @return The registered client, or null if not found.
     */
    @Override
    public RegisteredClient findByClientId(String clientId) {

        /*get the client with the client ID*/
        RegisteredClientEntity entity = registeredClientRepository
                .findRegisteredClientEntityByClientId(clientId)
                .orElseThrow();

        /*convert to registered client*/
        return entityToRegisteredClient(entity);
    }
}
