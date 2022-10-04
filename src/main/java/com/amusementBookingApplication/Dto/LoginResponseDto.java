package com.amusementBookingApplication.Dto;

public class LoginResponseDto {
	private String email;
	private boolean isLoggedIn;
	
	
	@Override
	public String toString() {
		return "LoginResponseDto [email=" + email + ", isLoggedIn=" + isLoggedIn + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isLoggedIn() {
		return isLoggedIn;
	}


	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	

}
