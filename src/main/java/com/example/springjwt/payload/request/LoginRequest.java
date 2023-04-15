package com.example.springjwt.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  private String mobile_phone;

	@NotBlank
	private String password;

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMbile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
