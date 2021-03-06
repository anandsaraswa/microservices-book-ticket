package com.anandsaraswa.as.api.common;

import com.anandsaraswa.as.api.entity.Account;

import lombok.Data;

@Data
public class TransactionRequest {
	
	private Account account;
	private Ticket ticket;
	
	public TransactionRequest() {
		super();
	}
	public TransactionRequest(Account account, Ticket ticket) {
		super();
		this.account = account;
		this.ticket = ticket;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
