package com.amusementBookingApplication.Exception;


@SuppressWarnings("serial")
public class InValidEmailException extends RuntimeException{
	
	public InValidEmailException(String msg) {
		super(msg);
	}
}
