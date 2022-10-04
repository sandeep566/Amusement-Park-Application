package com.amusementBookingApplication.Exception;

@SuppressWarnings("serial")
public class ZeroChargeException extends RuntimeException{
	public ZeroChargeException(String msg) {
		super(msg);
	}
}

