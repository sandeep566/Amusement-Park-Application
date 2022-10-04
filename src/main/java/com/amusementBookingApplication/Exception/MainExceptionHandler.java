package com.amusementBookingApplication.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.amusementBookingApplication.Entity.ErrorResponse;

@ControllerAdvice
public class MainExceptionHandler {
	
	@ExceptionHandler(CustomerExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomerExistsException e){
		
		ErrorResponse error = new ErrorResponse(e.getMessage());
		
		//error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(exception.getMessage()); 
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<ErrorResponse> myExpHandler1(InvalidId ie)
	{
		ErrorResponse err= new ErrorResponse(ie.getMessage());
	    return new ResponseEntity<ErrorResponse>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminExceptions.class)
	public ResponseEntity<ErrorResponse> myExpHandler4(AdminExceptions ae, WebRequest wr){
		ErrorResponse err= new ErrorResponse(ae.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(NoSuchActivityExistsException.class)
	public ResponseEntity<ErrorResponse> handleException2(NoSuchActivityExistsException exception){
		
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	} 
	
	
	@ExceptionHandler(NoSuchIdExistsException.class)
	public ResponseEntity<ErrorResponse> handleException3(NoSuchIdExistsException ex){
		ErrorResponse err = new ErrorResponse();
		err.setMessage(ex.getMessage());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ActivityAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(ActivityAlreadyExistsException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(exception.getMessage()); 
		
		
		return new ResponseEntity<>(error, HttpStatus.CONFLICT); 
	} 
	
	@ExceptionHandler(ZeroChargeException.class)
	public ResponseEntity<ErrorResponse> handleException(ZeroChargeException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(exception.getMessage()); 
		
		
		return new ResponseEntity<>(error, HttpStatus.CONFLICT); 
	} 
	
	@ExceptionHandler(InValidEmailException.class)
	public ResponseEntity<ErrorResponse> handleException(InValidEmailException exception){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setMessage(exception.getMessage()); 
		
		
		return new ResponseEntity<>(error, HttpStatus.CONFLICT); 
	} 
	

	

}
