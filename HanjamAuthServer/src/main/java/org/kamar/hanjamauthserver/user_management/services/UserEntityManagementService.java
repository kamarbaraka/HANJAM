package org.kamar.hanjamauthserver.user_management.services;

import lombok.RequiredArgsConstructor;
import org.kamar.hanjamauthserver.user_management.entities.UserEntity;
import org.kamar.hanjamauthserver.user_management.repositories.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;


/**
 * The UserEntityManagementService class is a service class that implements the UserDetailsManager interface.
 * It is responsible for creating, updating, deleting, and retrieving user information from the database.
 *
 * This service class specifically provides methods for managing UserEntity objects in the system.
 *
 * Note: This class does not contain example code or version information.
 *
 * @see UserDetailsManager
 * @see UserEntity
 * @see UserEntityRepository
 * @see PasswordEncoder
 *
 * @author samson baraka <kamar254baraka@gmail.com>
 */
@Service
@RequiredArgsConstructor
public class UserEntityManagementService implements UserDetailsManager {

    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * This method is used to create a new user in the system.
     * It takes a UserDetails object representing the user information as a parameter.
     * The UserDetails object must be an instance of UserEntity.
     * The method persists the user by saving the UserEntity object to the database using the UserRepository.
     *
     * @param user the UserDetails object representing the user to be created
     */
    @Override
    public void
    createUser(UserDetails user) {
        /*persist the user*/
        UserEntity userEntity = (UserEntity) user;

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setEnabled(true);
        userRepository.save(userEntity);
    }

    /**
     * Updates the details of an existing user.
     *
     * @param user the UserDetails object representing the updated user information
     */
    @Override
    public void updateUser(UserDetails user) {

        /*update the user*/
        userRepository.save((UserEntity) user);
    }

    /**
     * Deletes a user with the specified username from the system.
     *
     * @param username the username of the user
     */
    @Override
    public void deleteUser(String username) {

        /*delete the user*/
        userRepository.findUserEntitiesByUsername(username).ifPresent(userRepository::delete);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    /**
     * Check whether a user exists in the system.
     *
     * @param username the username of the user
     * @return true if the user exists, false otherwise
     */
    @Override
    public boolean userExists(String username) {
        /*check whether user exists*/
        return userRepository.existsUserEntityByUsername(username);
    }

    /**
     * Loads a user by their username.
     *
     * @param username the username of the user
     * @return the UserDetails object representing the user
     * @throws UsernameNotFoundException if no user with the given username is found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /*get the user with the username*/
        return userRepository.findUserEntitiesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("no such user."));
    }
}
