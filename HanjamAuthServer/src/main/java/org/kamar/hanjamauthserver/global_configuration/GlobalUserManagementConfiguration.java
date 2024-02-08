package org.kamar.hanjamauthserver.global_configuration;


import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;

/**
 * The GlobalUserManagementConfiguration class is a configuration class that configures the user management filter chain
 * in the HTTP security configuration and creates a PasswordEncoder bean for password encryption and decryption.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
@Configuration
@EnableWebSecurity
public class GlobalUserManagementConfiguration {

    /**
     * Configures the user management filter chain in the HTTP security configuration.
     *
     * @param httpSecurity hTTP security configuration object
     * @return configured SecurityFilterChain object
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain userManagementFilterChain(HttpSecurity httpSecurity) throws Exception{

        /*enable form login*/
        httpSecurity.formLogin(Customizer.withDefaults());

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }

    /**
     * Creates a PasswordEncoder bean that can be used to encode and decode passwords.
     *
     * @return passwordEncoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        /*create a map to hold the password encoders*/
        HashMap<String, PasswordEncoder> passwordEncoders = new HashMap<>();

        passwordEncoders.put("bcrypt", new BCryptPasswordEncoder());
        passwordEncoders.put(null, new PlainTextPasswordEncoder());

        /*build the delegating password encoder and return*/
        return new DelegatingPasswordEncoder("bcrypt", passwordEncoders);
    }
}

/**
 * The PlainTextPasswordEncoder class is an implementation of the PasswordEncoder interface that encodes
 * passwords using plain text.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
class PlainTextPasswordEncoder implements PasswordEncoder{

    /**
     * Encodes the given raw password.
     *
     * @param rawPassword the raw password to be encoded
     * @return the encoded password as a string
     */
    @NotNull
    @Override
    public String encode(@NotNull CharSequence rawPassword) {
        /*encode the password*/
        return rawPassword.toString();
    }

    /**
     * Checks if a raw password matches an encoded password.
     *
     * @param rawPassword the raw password to be checked
     * @param encodedPassword the encoded password to be compared against
     * @return true if the raw password matches the encoded password, false otherwise
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        /*match the passwords*/
        return rawPassword.toString().equals(encodedPassword);
    }
}
