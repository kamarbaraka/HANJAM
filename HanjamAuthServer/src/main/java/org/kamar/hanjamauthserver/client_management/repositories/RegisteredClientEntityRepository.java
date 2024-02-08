package org.kamar.hanjamauthserver.client_management.repositories;

import org.kamar.hanjamauthserver.client_management.entities.RegisteredClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


/**
 * The RegisteredClientEntityRepository interface is a repository for managing RegisteredClientEntity objects in the database.
 * It extends the JpaRepository interface, providing the basic CRUD operations for RegisteredClientEntity objects.
 *
 * <p>Example usage:</p>
 * <pre>
 *     Optional&lt;RegisteredClientEntity&gt; clientEntity = registeredClientEntityRepository.findRegisteredClientEntityByClientId("client_id");
 *     clientEntity.ifPresent(entity -> System.out.println(entity.getClientName()));
 * </pre>
 *
 * <p><b>Methods:</b></p>
 * <ul>
 *     <li>{@code findRegisteredClientEntityByClientId(String clientId)}: Retrieves a RegisteredClientEntity based on the specified clientId.</li>
 * </ul>
 *
 * Contributors:
 * <ul>
 *     <li>Samson Baraka - kamar254baraka@gmail.com</li>
 * </ul>
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Repository
public interface RegisteredClientEntityRepository extends JpaRepository<RegisteredClientEntity, UUID> {

    /**
     * Finds a RegisteredClientEntity by its clientId.
     *
     * @param clientId The clientId of the RegisteredClientEntity to find.
     * @return An Optional containing the RegisteredClientEntity if found, or empty if not found.
     */
    Optional<RegisteredClientEntity> findRegisteredClientEntityByClientId(String clientId);
}