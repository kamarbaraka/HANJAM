package org.kamar.hanjamauthserver.user_management.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.kamar.hanjamauthserver.user_management.entities.UserEntity;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

/**
 * Represents a UserEntityModel that contains user information.
 *
 * This class extends the RepresentationModel class and provides additional properties for user information.
 * It includes properties for the username, firstname, lastname, phoneNumber, and email.
 *
 * The class also overrides the equals and hashCode methods to perform equality check based on all properties.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Getter
@AllArgsConstructor
public class UserEntityModel extends RepresentationModel<UserEntityModel> {

    private String username;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserEntityModel that = (UserEntityModel) o;
        return Objects.equals(username, that.username)
                && Objects.equals(firstname, that.firstname)
                && Objects.equals(lastname, that.lastname)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, firstname, lastname, phoneNumber, email);
    }
}
