package com.buyconnex.buyconnex.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException {

@SuppressWarnings("unused")
private String message;
	
	public EmailAlreadyExistsException(String message)
	{
		super(message);
	}
}
