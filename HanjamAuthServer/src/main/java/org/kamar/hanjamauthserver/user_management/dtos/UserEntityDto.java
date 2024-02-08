package org.kamar.hanjamauthserver.user_management.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * DTO for {@link org.kamar.hanjamauthserver.user_management.entities.UserEntity}
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public record UserEntityDto(

        @NotNull(message = "username cannot be null.")
        @NotEmpty(message = "username cannot be empty.")
        @NotBlank(message = "username cannot be blank.")
        String username,

        @NotNull(message = "firstname cannot be null.")
        @NotEmpty(message = "firstname cannot be empty.")
        @NotBlank(message = "firstname cannot be blank.")
        String firstname,

        @NotNull(message = "lastname cannot be null.")
        @NotEmpty(message = "lastname cannot be empty.")
        @NotBlank(message = "lastname cannot be blank.")
        String lastname,

        @NotNull(message = "email cannot be null.")
        @Email(message = "value must be a valid email.")
        @NotEmpty(message = "email cannot be empty.")
        @NotBlank(message = "email cannot be blank.")
        String email,
        @NotNull(message = "phone number cannot be null.")
        /*@Pattern(message = "value must be a valid phone number.", regexp = "(?:[0-9] ?){6,14}[0-9]$")*/
        @NotEmpty(message = "phone number cannot be empty.")
        @NotBlank(message = "phone number cannot be blank.")
        String phoneNumber,
        @NotNull(message = "password cannot be null.")
        @Size(message = "password length too short or long.", min = 8, max = 50)
        /*@Pattern(message = "password does not meet the required pattern.",
                regexp = "(?=\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\\\\\S+$).{8,}")*/
        @NotEmpty(message = "password cannot be empty.")
        @NotBlank(message = "password cannot be null.")
        String password
) implements Serializable {
}