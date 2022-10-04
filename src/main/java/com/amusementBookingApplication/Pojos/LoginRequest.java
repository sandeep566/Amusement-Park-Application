package com.amusementBookingApplication.Pojos;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginRequest {
	public int id;
	public String userName;
	public String firstname;
	public String lastName;
	public String loginEmail;
	public String logiPassword;
	public String mobileNo;
	
	//public Job job;
	
}
