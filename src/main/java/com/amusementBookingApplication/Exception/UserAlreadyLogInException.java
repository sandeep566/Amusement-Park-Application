package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class UserAlreadyLogInException extends RuntimeException{
	public UserAlreadyLogInException(String msg) {
		super(msg);
	}
}
