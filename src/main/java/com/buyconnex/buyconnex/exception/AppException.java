package com.buyconnex.buyconnex.exception;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
