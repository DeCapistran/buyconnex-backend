package com.buyconnex.buyconnex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NameException extends RuntimeException{
	
	@SuppressWarnings("unused")
	private String message;
		
		public NameException(String message)
		{
			super(message);
		}

}
