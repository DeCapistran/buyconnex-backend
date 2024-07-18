package com.buyconnex.buyconnex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ConnexionException extends RuntimeException {

	@SuppressWarnings("unused")
	private String message;
		
		public ConnexionException(String message)
		{
			super(message);
		}
}
