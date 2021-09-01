package com.anandsaraswa.authenticate.entity;

public class AuthenticateResponse {
	
	private String jwt;
	
	public AuthenticateResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
