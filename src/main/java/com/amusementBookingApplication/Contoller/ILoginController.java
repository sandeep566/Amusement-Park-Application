package com.amusementBookingApplication.Contoller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amusementBookingApplication.Dto.LoginDto;
import com.amusementBookingApplication.Dto.LoginResponseDto;
import com.amusementBookingApplication.Entity.Login;
import com.amusementBookingApplication.Exception.EmailNotFoundException;
import com.amusementBookingApplication.Exception.InvalidCredentialsException;
import com.amusementBookingApplication.Exception.PasswordNotSameException;
import com.amusementBookingApplication.Pojos.LoginUpdate;
import com.amusementBookingApplication.Service.LoginService;



@RestController
public class ILoginController {
	
	@Autowired
	private LoginService loginServ;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/login/dto")
	ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) throws InvalidCredentialsException, PasswordNotSameException{
		System.out.println(loginDto);
		logger.info("Logging in");
		LoginResponseDto login= loginServ.login(loginDto);
		logger.info("Logged Successfully");
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PatchMapping("/logout/{email}")
	ResponseEntity<LoginResponseDto> logout(@PathVariable String email) throws EmailNotFoundException {
		logger.info("Logging out");
		LoginResponseDto resp = loginServ.logout(email);
		logger.info("Logged Succefully");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/updateLogin")
	ResponseEntity<Login> logout(@RequestBody LoginUpdate log)  {
		logger.info("updating login Details");
		Login resp = loginServ.updateLogIn(log);
		logger.info("login details updated");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	

}
