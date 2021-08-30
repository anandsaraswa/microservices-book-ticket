package com.anandsaraswa.gateway;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
	
	@RequestMapping("/account")
	public Mono<String> accountServiceFallback() {
		return Mono.just("Account service taking too long or down, please try again later") ;
	}
	
	@RequestMapping("/ticket")
	public Mono<String> ticketServiceFallback() {
		return Mono.just("Ticket service taking too long or down, please try again later");
	}

}
