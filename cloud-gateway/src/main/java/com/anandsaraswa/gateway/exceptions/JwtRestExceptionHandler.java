package com.anandsaraswa.gateway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anandsaraswa.gateway.entity.TransferResponse;

@ControllerAdvice
public class JwtRestExceptionHandler {
	
	/*
	 * User exception handler method  
	 * 
	 * 
	 * specific error handler
	 * */  
	
	@ExceptionHandler
	public ResponseEntity<TransferResponse> handleException(JwtTokenMalformedException userNotFoundException) {
		TransferResponse userErrorResponse = new TransferResponse();
		userErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		userErrorResponse.setMessage(userNotFoundException.getMessage());

		return new ResponseEntity<>(userErrorResponse, HttpStatus.BAD_REQUEST);

	}


}
