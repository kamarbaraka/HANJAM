package org.kamar.hanjamauthserver.user_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.kamar.hanjamauthserver.global_api_doc.specifications.UserManagementContract;
import org.kamar.hanjamauthserver.user_management.dtos.UserEntityDto;
import org.kamar.hanjamauthserver.user_management.entities.UserEntity;
import org.kamar.hanjamauthserver.user_management.models.UserEntityModel;
import org.kamar.hanjamauthserver.user_management.services.UserEntityManagementService;
import org.kamar.hanjamauthserver.user_management.services.UserEntityModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * The UserEntityManagementController class is the controller class that handles user management operations.
 * It implements the UserManagementContract interface which defines the contract for managing users.
 * This class is responsible for retrieving a user by their username and creating a new user.
 *
 * The class is annotated with the @RestController annotation to indicate that it is a RESTful controller that receives and responds to RESTful requests.
 * The class is also annotated with the @RequestMapping annotation to specify the base URL mapping for all the handler methods in the class.
 *
 * The UserDetailsManager and UserEntityModelAssembler dependencies are injected through constructor injection using the @RequiredArgsConstructor annotation.
 *
 * Note: This class should not be instantiated directly. Instead, it should be accessed through the REST API routes defined in the @RequestMapping annotation.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"api/v1/users"})
public class UserEntityManagementController implements UserManagementContract {

    private final UserDetailsManager userDetailsManager;
    private final UserEntityModelAssembler modelAssembler;

    /**
     * Retrieves a user by their username.
     *
     * @param username the username of the user to retrieve.
     * @return the ResponseEntity containing the UserEntityModel if a user with the given username exists, or empty if not found.
     */
    @Override
    @Operation(
                tags = {"User Management."},
                summary = "Api to get a user by their username.",
                description = ""
    )
    @GetMapping
    public ResponseEntity<UserEntityModel> getUserByUsername(@RequestParam("username") String username) {

        /*get the user with the username*/
        UserEntity userEntity = (UserEntity) userDetailsManager.loadUserByUsername(username);
        /*convert to a model*/
        UserEntityModel model = modelAssembler.toModel(userEntity);

        return ResponseEntity.ok(model);
    }

    /**
     * Creates a new user based on the provided UserEntityDto.
     *
     * @param userEntityDto userEntityDto object containing the user information.
     * @throws IllegalArgumentException if the userEntityDto is null or any of its required fields are null or empty.
     */
    @Override
    @Operation(
                tags = {"User Management."},
                summary = "Api to create a user.",
                description = ""
    )
    @PostMapping
    public void createUser(@Validated @RequestBody UserEntityDto userEntityDto) {

        UserEntity userEntity = UserEntity.builder().username(userEntityDto.username())
                .firstname(userEntityDto.firstname())
                .lastname(userEntityDto.lastname())
                .email(userEntityDto.email())
                .phoneNumber(userEntityDto.phoneNumber())
                .password(userEntityDto.password())
                .build();

        userDetailsManager.createUser(userEntity);
    }
}
