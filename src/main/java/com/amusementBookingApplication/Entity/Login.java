package com.amusementBookingApplication.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Login {
	@Id
	@GeneratedValue
	private int id;
	@Email(message="Enter valid email address")
	private String loginEmail;
	@NotEmpty(message="Please Enter a Password")
	@Length(min=6,max=20)
	private String loginPassword;
	private boolean isLoggedIn =false;
	
	@Enumerated(EnumType.STRING)
	private Job job;
	
	public Login() {
		super();
	}

	public Login(int id, @Email(message = "Enter valid email address") String loginEmail,
			@NotEmpty(message = "Please Enter a Password") @Length(min = 6, max = 20) String loginPassword,
			boolean isLoggedIn) {
		super();
		this.id = id;
		this.loginEmail = loginEmail;
		this.loginPassword = loginPassword;
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", loginEmail=" + loginEmail + ", loginPassword=" + loginPassword + ", isLoggedIn="
				+ isLoggedIn + ", getId()=" + getId() + ", getLoginEmail()=" + getLoginEmail() + ", getLoginPassword()="
				+ getLoginPassword() + ", isLoggedIn()=" + isLoggedIn() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	

}
