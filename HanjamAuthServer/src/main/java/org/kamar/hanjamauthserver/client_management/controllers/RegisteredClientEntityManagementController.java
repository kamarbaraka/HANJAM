package org.kamar.hanjamauthserver.client_management.controllers;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.kamar.hanjamauthserver.client_management.dtos.RegisteredClientEntityDto;
import org.kamar.hanjamauthserver.client_management.entities.RegisteredClientEntity;
import org.kamar.hanjamauthserver.client_management.models.RegisteredClientEntityModel;
import org.kamar.hanjamauthserver.client_management.services.RegisteredClientEntityManagementService;
import org.kamar.hanjamauthserver.client_management.services.RegisteredClientEntityModelAssembler;
import org.kamar.hanjamauthserver.global_api_doc.specifications.RegisteredClientManagementApi;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"api/registeredClients", "/registeredClients"})
public class RegisteredClientEntityManagementController implements RegisteredClientManagementApi {

    private final RegisteredClientEntityModelAssembler modelAssembler;
    private final RegisteredClientEntityManagementService service;


    @Operation(
                tags = {"Client Management."},
                summary = "Api to register a client application.",
                description = ""
    )
    @PostMapping
    @Override
    public ResponseEntity<RegisteredClientEntityModel> registerClient(@RequestBody @Validated RegisteredClientEntityDto dto) {

        /*register the client*/
        RegisteredClientEntityModel model = service.registerClient(dto);
        /*respond*/
        return ResponseEntity.ok(model);
    }

    @Operation(
                tags = {"Client Management."},
                summary = "Api to get a client app by its client ID",
                description = ""
    )
    @GetMapping
    @Override
    public ResponseEntity<RegisteredClientEntityModel> getRegisteredClientByClientID(
            @RequestParam("withClientId") final String clientId) {


        /*get the client with the ID*/
        RegisteredClientEntity entity = service.getRegisteredClientByClientId(clientId);
        /*convert to model and respond*/
        RegisteredClientEntityModel model = modelAssembler.toModel(entity);
        return ResponseEntity.ok(model);
    }
}
