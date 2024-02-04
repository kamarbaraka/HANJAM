package org.kamar.hanjamauthserver.user_management.exceptions;



/**
 * UserEntityException is a custom runtime exception that can be thrown in the UserEntity class or its sub-classes.
 * It provides a way to handle user-related exceptions in a centralized manner.
 *
 * @author samson baraka <kamar254baraka@gmail.com>.
 */
public class UserEntityException extends RuntimeException{

    public UserEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
