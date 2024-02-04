package org.kamar.hanjamauthserver.user_management.repositories;

import org.kamar.hanjamauthserver.user_management.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The UserEntityRepository interface is a repository interface that extends JpaRepository for managing UserEntity objects in a database.
 * It provides methods for CRUD operations, as well as additional custom queries.
 * The repository is responsible for retrieving and persisting UserEntity objects to/from the database.
 *
 * This repository specifically provides a method for finding a UserEntity by username (case-insensitive).
 *
 * Note: This interface does not contain example code or version information.
 *
 * @see UserEntity
 * @see JpaRepository
 * @see Optional
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntitiesByUsername(String username);
    boolean existsUserEntityByUsername(String username);
}