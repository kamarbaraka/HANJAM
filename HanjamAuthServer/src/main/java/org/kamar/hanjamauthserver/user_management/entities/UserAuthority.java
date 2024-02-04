package org.kamar.hanjamauthserver.user_management.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * The UserAuthority class represents the authority of a user in the system.
 * It implements the GrantedAuthority interface from Spring Security.
 *
 * The authority string represents a permission or role that a user has.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Getter
@Entity(name = "authorities")
@NoArgsConstructor
public class UserAuthority implements GrantedAuthority {

    private static final String  READ_USER = "read_user";
    private static final String  READ_USERS = "read_users";
    private static final String  CREATE_USER = "create_user";
    private static final String  READ_CLIENT = "read_client";
    private static final String  CREATE_CLIENT = "create_client";

    @Id
    @NotBlank(message = "authority cannot be blank.")
    @NotEmpty(message = "authority cannot be empty.")
    @NotNull(message = "authority cannot be null.")
    @Column(nullable = false)
    private String authority;

    /**
     * Constructs a new UserAuthority object with the given authority.
     *
     * @param authority the authority associated with the UserAuthority
     */
    UserAuthority(String authority) {
        this.authority = authority;
    }

}
