package com.anandsaraswa.gateway.entity;

public class TokenResponse {
	
	private String message;
	private String role;
	private boolean valid;

	public TokenResponse() {
		super();
	}
	
	public TokenResponse(String message, String role, Boolean valid) {
		super();
		this.message = message;
		this.role = role;
		this.valid = valid;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
