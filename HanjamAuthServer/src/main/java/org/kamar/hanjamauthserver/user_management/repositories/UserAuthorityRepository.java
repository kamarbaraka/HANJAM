package org.kamar.hanjamauthserver.user_management.repositories;

import org.kamar.hanjamauthserver.user_management.entities.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The UserAuthorityRepository interface extends the JpaRepository interface.
 * It provides database CRUD operations for the UserAuthority entity.
 *
 * The UserAuthority entity represents the authority of a user in the system,
 * implementing the GrantedAuthority interface from Spring Security.
 *
 * The authority string represents a permission or role that a user has.
 *
 * This interface is responsible for managing UserAuthority records in the database.
 * CRUD operations such as saving, updating, and deleting UserAuthority records
 * can be performed using methods provided by this interface.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, String> {
}