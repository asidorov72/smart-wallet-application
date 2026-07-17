package app.exception.user;

import app.exception.ApplicationException;

public class UserAlreadyExistsException extends ApplicationException {
    public UserAlreadyExistsException(String username) {
        super(
                "User with this " + username + " already exists!",
                "409",
                "User already exists"
        );
    }
}
