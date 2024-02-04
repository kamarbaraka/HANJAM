package org.kamar.hanjamauthserver.user_management.services;

import org.kamar.hanjamauthserver.user_management.entities.UserEntity;
import org.kamar.hanjamauthserver.user_management.models.UserEntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * The UserEntityModelAssembler class is responsible for converting UserEntity objects to UserEntityModel objects and collections of UserEntity objects to collections of UserEntity
 *Model objects.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Service
public class UserEntityModelAssembler implements RepresentationModelAssembler<UserEntity, UserEntityModel> {
    /**
     * Converts a UserEntity object to a UserEntityModel object.
     *
     * @param entity The UserEntity object to convert.
     * @return The converted UserEntityModel object.
     */
    @Override
    public UserEntityModel toModel(UserEntity entity) {

        /*create the model*/
        UserEntityModel model = new UserEntityModel(
                entity.getUsername(),
                entity.getFirstname(),
                entity.getLastname(),
                entity.getPhoneNumber(),
                entity.getEmail()
        );

        /*add links to the model*/

        /*return*/
        return model;
    }

    /**
     * Converts a collection of UserEntity objects to a collection of UserEntityModel objects.
     *
     * @param entities the collection of UserEntity objects to be converted
     * @return a CollectionModel of UserEntityModel objects representing the converted entities
     */
    @Override
    public CollectionModel<UserEntityModel> toCollectionModel(Iterable<? extends UserEntity> entities) {

        /*convert the entities to models*/
        ArrayList<UserEntityModel> models = new ArrayList<>();
        entities.forEach(userEntity -> models.add(toModel(userEntity)));
        return CollectionModel.of(models);
    }
}
