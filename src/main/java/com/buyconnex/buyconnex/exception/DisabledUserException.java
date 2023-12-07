package com.buyconnex.buyconnex.exception;

public class DisabledUserException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DisabledUserException(String message) {
        super(message);
    }
}
