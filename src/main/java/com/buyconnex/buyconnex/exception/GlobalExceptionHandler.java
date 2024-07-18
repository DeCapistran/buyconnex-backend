package com.buyconnex.buyconnex.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings("serial")
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	 public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception,
	 WebRequest webRequest){
		
	 ErrorDetails errorDetails = new ErrorDetails(
			 LocalDateTime.now(),
			 exception.getMessage(),
			 webRequest.getDescription(false),
			 "USER_EMAIL_ALREADY_EXISTS"
	 );
	 return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	 }
	
	@ExceptionHandler(ConnexionException.class)
	 public ResponseEntity<ErrorDetails> handleConnexionException(ConnexionException exception,
	 WebRequest webRequest){
		
	 ErrorDetails errorDetails = new ErrorDetails(
			 LocalDateTime.now(),
			 exception.getMessage(),
			 webRequest.getDescription(false),
			 "NO_CONNEXION"
	 );
	 return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	 }
	
	@ExceptionHandler(BadPasswordException.class)
	 public ResponseEntity<ErrorDetails> handleBadPasswordException(BadPasswordException exception,
	 WebRequest webRequest){
		
	 ErrorDetails errorDetails = new ErrorDetails(
			 LocalDateTime.now(),
			 exception.getMessage(),
			 webRequest.getDescription(false),
			 "BAD_PASSWORD"
	 );
	 return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	 }
	 
	
	@ExceptionHandler(ExpiredTokenException.class)
	public ResponseEntity<ErrorDetails>
	handleExpiredTokenException(ExpiredTokenException exception,
			WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"EXPIRED_TOKEN"
				);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ErrorDetails>
	handleInvalidTokenException(InvalidTokenException exception,
			WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"INVALID_TOKEN"
				);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
