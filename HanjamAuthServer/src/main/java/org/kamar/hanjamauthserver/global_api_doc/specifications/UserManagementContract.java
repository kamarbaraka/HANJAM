package org.kamar.hanjamauthserver.global_api_doc.specifications;

import jakarta.validation.constraints.NotNull;
import org.kamar.hanjamauthserver.user_management.dtos.UserEntityDto;
import org.kamar.hanjamauthserver.user_management.models.UserEntityModel;
import org.springframework.http.ResponseEntity;

/**
 * The UserManagementContract interface defines the contract for managing users.
 * It provides methods for retrieving a user by their username and creating a new user.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public interface UserManagementContract {

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve.
     * @return the ResponseEntity containing the UserEntityModel if a user with the given username exists, or empty if not found.
     */
    ResponseEntity<UserEntityModel> getUserByUsername(@NotNull String username);

    /**
     * Creates a new user based on the provided UserEntityDto.
     *
     * @param userEntityDto userEntityDto object containing the user information.
     * @throws IllegalArgumentException if the userEntityDto is null or any of its required fields are null or empty.
     */
    void createUser(@NotNull UserEntityDto userEntityDto);
}
