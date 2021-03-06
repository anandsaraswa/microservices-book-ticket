package com.anandsaraswa.as.api.common;



public class Ticket {
	
	private int id;
	private String status;
	private double price;
	private String source;
	private String destination;
	private String transactionId;
	private int accountId;
	
	public Ticket() {
		super();
	}
	public Ticket(int id, double price, String source, String destination, String transactionId) {
		super();
		this.id = id;
		this.price = price;
		this.source = source;
		this.destination = destination;
		this.transactionId = transactionId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
