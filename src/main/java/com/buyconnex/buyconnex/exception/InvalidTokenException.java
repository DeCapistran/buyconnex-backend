package com.buyconnex.buyconnex.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidTokenException extends RuntimeException {

@SuppressWarnings("unused")
private String message;
	
	public InvalidTokenException(String message)
	{
		super(message);
	}
}
