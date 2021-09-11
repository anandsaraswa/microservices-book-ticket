package com.anandsaraswa.gateway.config;

import java.util.HashMap;
import java.util.Map;

import com.anandsaraswa.gateway.entity.AuthorizedPojo;

public class AuthorizedMapper {
	
	public static final Map<AuthorizedPojo,String> authorizedMap =  new HashMap<>();
	
	public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	private  AuthorizedMapper() {
		super();
	}
	
	static {
		authorizedMap.put(new AuthorizedPojo("/account/create","POST"), ROLE_ADMIN);
		
		authorizedMap.put(new AuthorizedPojo("/ticket/book","POST"), ROLE_EMPLOYEE);
		
	}
}
