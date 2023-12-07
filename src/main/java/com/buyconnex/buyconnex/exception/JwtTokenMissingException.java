package com.buyconnex.buyconnex.exception;

public class JwtTokenMissingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JwtTokenMissingException(String message) {
        super(message);
    }
}
