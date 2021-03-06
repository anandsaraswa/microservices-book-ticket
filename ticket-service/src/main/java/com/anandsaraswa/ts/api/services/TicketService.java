package com.anandsaraswa.ts.api.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anandsaraswa.ts.api.entity.Ticket;
import com.anandsaraswa.ts.api.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepo;
	
	public Ticket bookTicket(Ticket ticket) {
		ticket.setTransactionId(UUID.randomUUID().toString());
		return ticketRepo.save(ticket);
	}
	
	public Ticket findTicketByTicketNumber(String transactionId) {
		
		return ticketRepo.findByTransactionId(transactionId);
	}
}
