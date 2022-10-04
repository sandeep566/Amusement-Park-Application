package com.amusementBookingApplication.Service;

import com.amusementBookingApplication.Dto.LoginDto;
import com.amusementBookingApplication.Dto.LoginResponseDto;
import com.amusementBookingApplication.Entity.Login;
import com.amusementBookingApplication.Exception.EmailNotFoundException;
import com.amusementBookingApplication.Exception.InvalidCredentialsException;
import com.amusementBookingApplication.Exception.PasswordNotSameException;
import com.amusementBookingApplication.Pojos.LoginUpdate;

public interface LoginService {
	
	LoginResponseDto login(LoginDto logindto) throws InvalidCredentialsException, PasswordNotSameException;
	LoginResponseDto logout(String email) throws EmailNotFoundException;
	Login updateLogIn(LoginUpdate log);

}
