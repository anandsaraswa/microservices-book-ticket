package com.anandsaraswa.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anandsaraswa.gateway.filter.JwtAuthenticationFilterFactory;

@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilterFactory filter;
	/*
	 * @Bean public RouteLocator routes(RouteLocatorBuilder builder) { return
	 * builder.routes().route("TICKET-SERVICE", r -> r.path("/ticket/**").filters(f
	 * -> f.filter(filter)).uri("lb://ACCOUNT-SERVICE")) .route("ACCOUNT-SERVICE", r
	 * -> r.path("/account/**").filters(f ->
	 * f.filter(filter)).uri("lb://ACCOUNT-SERVICE")).build(); }
	 */

}