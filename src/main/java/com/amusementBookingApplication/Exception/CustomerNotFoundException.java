package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception{
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
