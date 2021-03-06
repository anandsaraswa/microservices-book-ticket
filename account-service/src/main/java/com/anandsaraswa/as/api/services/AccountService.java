package com.anandsaraswa.as.api.services;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anandsaraswa.as.api.common.Ticket;
import com.anandsaraswa.as.api.common.TransactionRequest;
import com.anandsaraswa.as.api.common.TransactionResponse;
import com.anandsaraswa.as.api.entity.Account;
import com.anandsaraswa.as.api.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	@Lazy
	private RestTemplate restTemp;
	
	@Value("${test}")
	private String ENDPOINT_TICKET_URL;
	
	
	public TransactionResponse saveAccount(TransactionRequest txnReq) {

		String response =  "";
		Account  account = txnReq.getAccount();  
		Ticket ticket = txnReq.getTicket();
		ticket.setAccountId(account.getId());
		ticket.setSource(account.getSource());
		ticket.setDestination(account.getDestination());
		ticket.setPrice(account.getPrice());
		
		//rest call
		Ticket ticketResponse = restTemp.postForObject(ENDPOINT_TICKET_URL, ticket, Ticket.class);
		response =  ticketResponse.getStatus().equals("success")?"Ticket booked":"Ticket not booked";
		accountRepo.save(account);
		return new TransactionResponse(account,ticketResponse.getTransactionId(),response);
	}
	
	

}
