package org.kamar.hanjamauthserver.user_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The User class represents a user in the system.
 * It implements the UserDetails interface to provide necessary information for user authentication and authorization.
 * The class is annotated with @Entity to specify that it is a persistent entity in a database table called "users".
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Getter
@Setter
@Entity(name = "users")
@Component
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private long userId;

    @NotNull(message = "username cannot be null.")
    @NotEmpty(message = "username cannot be empty.")
    @NotBlank(message = "username cannot be blank.")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull(message = "firstname cannot be null.")
    @NotEmpty(message = "firstname cannot be empty.")
    @NotBlank(message = "firstname cannot be blank.")
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @NotNull(message = "lastname cannot be null.")
    @NotEmpty(message = "lastname cannot be empty.")
    @NotBlank(message = "lastname cannot be blank.")
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Email(message = "value must be a valid email.")
    @NotBlank(message = "email cannot be blank.")
    @NotEmpty(message = "email cannot be empty.")
    @NotNull(message = "email cannot be null.")
    @Column(nullable = false)
    private String email;

//    @Pattern(message = "value must be a valid phone number.", regexp = "^\\\\+(?:[0-9] ?){6,14}[0-9]$")
    @NotBlank(message = "phone number cannot be blank.")
    @NotEmpty(message = "phone number cannot be empty.")
    @NotNull(message = "phone number cannot be null.")
    @Column(nullable = false, unique = true)
    private String phoneNumber;


    /*@Pattern(message = "password does not meet the required pattern.",
            regexp = "(?=\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\\\\\S+$).{8,}")*/
//    @Length(message = "password length too short or long.", min = 8, max = 50)
    @NotBlank(message = "password cannot be null.")
    @NotEmpty(message = "password cannot be empty.")
    @NotNull(message = "password cannot be null.")
    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
    fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority"))
    private Set<UserAuthority> authorities = new LinkedHashSet<>();

    @NotNull
    @Column(name = "created_on", nullable = false)
    private final LocalDateTime createdOn = LocalDateTime.now();

    @NotNull
    @Column(nullable = false)
    private final Instant updatedOn = Instant.now();

    private boolean accountPremium = false;

    private boolean accountVerified = false;

    private boolean enabled = false;

    private boolean accountNonLocked = true;

    private boolean accountNonExpired = true;

    private boolean credentialsNonExpired = true;

}