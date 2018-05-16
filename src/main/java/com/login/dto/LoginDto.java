package com.login.dto;

import javax.validation.constraints.NotNull;

public class LoginDto {
	
	@NotNull(message = "Email cannot be Empty")
	private String email;

	@NotNull(message = "Password cannot be Empty")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
