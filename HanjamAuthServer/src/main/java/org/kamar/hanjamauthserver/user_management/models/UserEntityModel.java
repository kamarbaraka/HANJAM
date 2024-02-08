package org.kamar.hanjamauthserver.user_management.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;


/**
 * Represents a UserEntityModel that contains user information.
 *
 * This class extends the RepresentationModel class and provides additional properties for user information.
 * It includes properties for the username, firstname, lastname, phoneNumber, and email.
 *
 * The class also overrides the equals and hashCode methods to perform equality check based on all properties.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntityModel extends RepresentationModel<UserEntityModel> {

    private String username;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

}
