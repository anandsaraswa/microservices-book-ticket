package com.anandsaraswa.gateway.exceptions;


import javax.naming.AuthenticationException;

public class JwtTokenMalformedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JwtTokenMalformedException(String msg) {
		super(msg);
	}

}