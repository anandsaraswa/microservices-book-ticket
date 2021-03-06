package com.anandsaraswa.ts.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anandsaraswa.ts.api.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	  
	Ticket findByTransactionId(String transactionId);

}
