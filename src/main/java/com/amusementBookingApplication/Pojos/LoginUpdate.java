package com.amusementBookingApplication.Pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUpdate {
	
	public int updateId;
	public String email;
	public String password;
}
