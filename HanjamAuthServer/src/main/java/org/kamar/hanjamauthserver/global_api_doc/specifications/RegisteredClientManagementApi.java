package org.kamar.hanjamauthserver.global_api_doc.specifications;

import jakarta.validation.constraints.NotNull;
import org.kamar.hanjamauthserver.client_management.dtos.RegisteredClientEntityDto;
import org.kamar.hanjamauthserver.client_management.models.RegisteredClientEntityModel;
import org.springframework.http.ResponseEntity;

/**
 * This interface represents an API for managing registered clients.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
public interface RegisteredClientManagementApi {

    @NotNull
    ResponseEntity<RegisteredClientEntityModel> registerClient(@NotNull RegisteredClientEntityDto dto);
    ResponseEntity<RegisteredClientEntityModel> getRegisteredClientByClientID(final String clientId);
}
