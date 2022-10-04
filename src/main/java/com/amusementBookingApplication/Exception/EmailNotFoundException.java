package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class EmailNotFoundException extends RuntimeException{
	public EmailNotFoundException(String msg) {
		super(msg);
	}

}
