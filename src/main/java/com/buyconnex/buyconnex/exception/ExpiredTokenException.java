package com.buyconnex.buyconnex.exception;

import javax.naming.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExpiredTokenException extends AuthenticationException {

	@SuppressWarnings("unused")
	private String message;

    public ExpiredTokenException(String message) {
        super(message);
    }
}
