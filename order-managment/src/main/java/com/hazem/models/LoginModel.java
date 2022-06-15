package com.hazem.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

	
	@NotNull(message="Username is required")
	@Size(min = 3, max = 15, message = " Username must be between 3 and 15 characters")
	private String username;
	
	@NotNull
	@Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
	private String password;
	
	
	
	
	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}


	public LoginModel() {
		super();
	}


	public LoginModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
