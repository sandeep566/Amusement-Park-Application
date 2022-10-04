package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class NoSuchActivityExistsException extends RuntimeException{
	
	public NoSuchActivityExistsException() {
	}
	
	public NoSuchActivityExistsException(String msg) {
		super(msg);
	}

}
