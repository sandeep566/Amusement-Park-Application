package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class CustomerExistsException extends RuntimeException{
	public CustomerExistsException(String msg) {
		super(msg);
	}
}
