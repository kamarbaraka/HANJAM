package org.kamar.hanjamauthserver.user_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link org.kamar.hanjamauthserver.user_management.entities.UserAuthority}
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public record UserAuthorityDto(
        @NotNull(message = "authority cannot be null.")
        @NotEmpty(message = "authority cannot be empty.")
        @NotBlank(message = "authority cannot be blank.")
        String authority
) implements Serializable {
}