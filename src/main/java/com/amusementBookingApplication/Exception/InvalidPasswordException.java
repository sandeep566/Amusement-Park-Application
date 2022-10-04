package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class InvalidPasswordException extends RuntimeException {
	public InvalidPasswordException() {
		// TODO Auto-generated constructor stub
	}
	public InvalidPasswordException(String message) {
		super(message);
	}
}