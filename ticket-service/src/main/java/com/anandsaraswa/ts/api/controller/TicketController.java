package com.anandsaraswa.ts.api.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anandsaraswa.ts.api.entity.Ticket;
import com.anandsaraswa.ts.api.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketservice;
	
	@PostMapping("/book")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		ticket.setStatus(ticketProcessing());
		return ticketservice.bookTicket(ticket);
	}
	
	@GetMapping("/{transactionId}")
	public Ticket getTicketHistoryByTicketNumber(@PathVariable String transactionId) {
		return ticketservice.findTicketByTicketNumber(transactionId);
	}
	
	public String ticketProcessing() {
		return new Random().nextBoolean()?"success":"false";
	}

}
