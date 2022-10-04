package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class ActivityAlreadyExistsException extends RuntimeException {
	
	public ActivityAlreadyExistsException() {
		
	}
	public ActivityAlreadyExistsException(String msg) {
		super(msg);
		
	}

}
