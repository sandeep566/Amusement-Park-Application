package com.amusementBookingApplication.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amusementBookingApplication.Dto.LoginDto;
import com.amusementBookingApplication.Dto.LoginResponseDto;
import com.amusementBookingApplication.Entity.Login;
import com.amusementBookingApplication.Exception.EmailNotFoundException;
import com.amusementBookingApplication.Exception.InvalidCredentialsException;
import com.amusementBookingApplication.Exception.PasswordNotSameException;
import com.amusementBookingApplication.Exception.UserAlreadyLogInException;
import com.amusementBookingApplication.Pojos.LoginUpdate;
import com.amusementBookingApplication.Repository.ILoginRepository;


@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private ILoginRepository loginRepo;
	
	
	@SuppressWarnings("unused")
	@Override
	public LoginResponseDto login(LoginDto loginDto) throws InvalidCredentialsException, PasswordNotSameException {
		Optional<Login> dbLoginOpt = loginRepo.findByLoginEmail(loginDto.getLoginEmail());
		
		if (dbLoginOpt.isPresent()) {
			// compare database password with user provided password
			// if password matching return credentials else throw exception
			Login log = dbLoginOpt.get();
			if(log.isLoggedIn()==false) {
					if (log.getLoginPassword().equals(loginDto.getLoginPassword())) {
					    
					// if credentials matches, set loggedIn flag as true and save
						log.setLoggedIn(true);
						
						Login updatedLogin = loginRepo.save(log);
						LoginResponseDto resDto = new LoginResponseDto();
						
						resDto.setEmail(log.getLoginEmail());
						resDto.setLoggedIn(log.isLoggedIn());
						log.setLoggedIn(true);
						return resDto;
					}else {
						throw new InvalidCredentialsException("Incorrect Password");
					}
			}else {
				throw new UserAlreadyLogInException("User Already logged in");
			}
					
		}else {
			// throw exception if given email not present in the db.
			throw new InvalidCredentialsException("User not found with email: "+loginDto.getLoginEmail());
		}
	}
	
		@SuppressWarnings("unused")
		@Override
		public LoginResponseDto logout(String email) throws EmailNotFoundException {
			Optional<Login> dbLoginOpt = loginRepo.findByLoginEmail(email);
			if(dbLoginOpt.isPresent()) {
				// update isLoggedIn flag as false and save
				Login login = dbLoginOpt.get();
				// Update flag to false and save
				login.setLoggedIn(false);
				Login updatedLogin = loginRepo.save(login);
				// Convert Login obj to LoginRespDto
				LoginResponseDto resDto = new LoginResponseDto();
				resDto.setEmail(email);
				resDto.setLoggedIn(false);
				// return LoginRespDto obj
				return resDto;
			}
			else {
				throw new EmailNotFoundException("User not found with email: "+email);
			}
		}
		
		@Override
		public Login updateLogIn(LoginUpdate log) {
			Optional<Login> l1 = loginRepo.findById(log.getUpdateId());
			if(l1.isPresent()) {
				Login l2 = l1.get();
				l2.setId(log.getUpdateId());
				l2.setLoginEmail(log.getEmail());
				l2.setLoginPassword(log.getPassword());
				return loginRepo.save(l2);
			}else {
				throw new InvalidCredentialsException("User not found with that id");
			}
		}
	
	

}
