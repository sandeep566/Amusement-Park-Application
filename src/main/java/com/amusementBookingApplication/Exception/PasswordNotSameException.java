package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class PasswordNotSameException extends RuntimeException {
	public PasswordNotSameException(String msg) {
		super(msg);
	}

}
