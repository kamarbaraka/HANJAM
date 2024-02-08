package org.kamar.hanjamauthserver.client_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link org.kamar.hanjamauthserver.client_management.entities.RegisteredClientEntity}
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public record RegisteredClientEntityDto(
        @NotNull(message = "client name cannot be null.")
        @NotEmpty(message = "client name cannot be empty.")
        @NotBlank(message = "client name cannot be blank.")
        String clientName,
        @NotNull(message = "redirect uri cannot be null.")
        @NotEmpty(message = "redirect uri cannot be empty.")
        @NotBlank(message = "redirect uri cannot be blank.")
        String redirectUri,
        @NotNull(message = "post logout redirect uri cannot be null.")
        @NotEmpty(message = "post logout redirect uri cannot be empty.")
        @NotBlank(message = "post logout redirect uri cannot be blank.")
        String postLogoutRedirectUri,
        @NotNull(message = "scope cannot be null.")
        @NotEmpty(message = "scope cannot be empty.")
        @NotBlank(message = "scope cannot be blank.")
        Set<String> scopes
) implements Serializable {
}