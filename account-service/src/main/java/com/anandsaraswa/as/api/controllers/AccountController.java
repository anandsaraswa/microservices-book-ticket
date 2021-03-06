package com.anandsaraswa.as.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anandsaraswa.as.api.common.TransactionRequest;
import com.anandsaraswa.as.api.common.TransactionResponse;
import com.anandsaraswa.as.api.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountservice;
	
	@PostMapping("/create")
	public TransactionResponse createAccount(@RequestBody TransactionRequest txnReq) {
		return accountservice.saveAccount(txnReq);
	}

}
