package org.kamar.hanjamauthserver.client_management.services;

import org.kamar.hanjamauthserver.client_management.entities.RegisteredClientEntity;
import org.kamar.hanjamauthserver.client_management.models.RegisteredClientEntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * The RegisteredClientEntityModelAssembler class is responsible for converting RegisteredClientEntity objects to RegisteredClientEntityModel objects and a collection of Registered
 *ClientEntity objects to a CollectionModel of RegisteredClientEntityModel objects.
 *
 * <p>Example usage:</p>
 * <pre>
 *     RegisteredClientEntityModelAssembler assembler = new RegisteredClientEntityModelAssembler();
 *     RegisteredClientEntity entity = new RegisteredClientEntity();
 *     RegisteredClientEntityModel model = assembler.toModel(entity);
 *     CollectionModel<RegisteredClientEntityModel> collectionModel = assembler.toCollectionModel(List.of(entity));
 * </pre>
 *
 * <p><b>Methods:</b></p>
 * <ul>
 *     <li>{@code toModel(RegisteredClientEntity entity)}: Converts a RegisteredClientEntity object to a RegisteredClientEntityModel object.</li>
 *     <li>{@code toCollectionModel(Iterable<? extends RegisteredClientEntity> entities)}: Converts a collection of RegisteredClientEntity objects to a CollectionModel of Registered
 *ClientEntityModel objects.</li>
 * </ul>
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Service
public class RegisteredClientEntityModelAssembler implements RepresentationModelAssembler<RegisteredClientEntity, RegisteredClientEntityModel> {
    /**
     * Converts a RegisteredClientEntity object to a RegisteredClientEntityModel object.
     *
     * @param entity the RegisteredClientEntity to convert
     * @return a RegisteredClientEntityModel object representing the converted RegisteredClientEntity
     */
    @Override
    public RegisteredClientEntityModel toModel(RegisteredClientEntity entity) {

        /*create a new model*/
        return new RegisteredClientEntityModel(
                entity.getClientName(),
                entity.getClientId(),
                entity.getClientSecret()
        );
    }

    /**
     * Converts a collection of RegisteredClientEntity objects to a CollectionModel of RegisteredClientEntityModel objects.
     *
     * @param entities the collection of RegisteredClientEntity objects to convert
     * @return a CollectionModel containing the converted RegisteredClientEntityModel objects
     */
    @Override
    public CollectionModel<RegisteredClientEntityModel> toCollectionModel(Iterable<? extends RegisteredClientEntity> entities) {

        /*convert the entities to a collection model.*/
        List<RegisteredClientEntityModel> models = new ArrayList<>();
        entities.forEach(entity -> models.add(toModel(entity)));
        return CollectionModel.of(models);
    }
}
