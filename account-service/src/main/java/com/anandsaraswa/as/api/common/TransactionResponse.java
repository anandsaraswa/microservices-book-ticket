package com.anandsaraswa.as.api.common;

import com.anandsaraswa.as.api.entity.Account;

public class TransactionResponse {
	
	private Account account;
	private String transactionId;
	private String message;
	
	
	public TransactionResponse() {
		super();
	}
	public TransactionResponse(Account account, String transactionId, String message) {
		super();
		this.account = account;
		this.transactionId = transactionId;
		this.message = message;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
