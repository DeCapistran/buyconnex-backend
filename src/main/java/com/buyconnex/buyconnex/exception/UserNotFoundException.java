package com.buyconnex.buyconnex.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 226438743987438L;

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
