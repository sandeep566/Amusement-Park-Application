package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class NoSuchIdExistsException extends RuntimeException {
	
	public NoSuchIdExistsException() {
		
	}
	
	public NoSuchIdExistsException(String msg) {
		super(msg);
	}

}
