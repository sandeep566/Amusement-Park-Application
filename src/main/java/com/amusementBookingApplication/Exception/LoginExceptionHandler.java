package com.amusementBookingApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amusementBookingApplication.Entity.ErrorResponse;


@ControllerAdvice
public class LoginExceptionHandler {
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmailNotFoundException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		//error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage()); 
		//error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleException(InvalidCredentialsException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		//error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage()); 
		//error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	

	@ExceptionHandler(PasswordNotSameException.class)
	public ResponseEntity<ErrorResponse> handleException(PasswordNotSameException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		//error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage()); 
		//error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(UserAlreadyLogInException.class)
	public ResponseEntity<ErrorResponse> handleException(UserAlreadyLogInException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		//error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage()); 
		//error.setTimeStamp(LocalDateTime.now()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	
	
	

}
