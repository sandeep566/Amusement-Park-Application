package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException {
	
	public InvalidCredentialsException(String msg) {
		super(msg);
	}

}
