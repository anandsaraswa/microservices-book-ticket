package com.anandsaraswa.gateway.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.anandsaraswa.gateway.entity.TokenResponse;

@RefreshScope
@Service
public class AuthService {
	
	
	@Value("${auth}")
	private String ENDPOINT_AUTH_URL;
	
	public void validateToken(String token) {
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON);
		 * headers.add(HttpHeaders.AUTHORIZATION, "Bearer "+token); URI uri = new
		 * URI(ENDPOINT_AUTH_URL);
		 * 
		 * HttpEntity<String> requestEntity = new HttpEntity<>(null, headers); return
		 * restTemp.exchange(uri, HttpMethod.GET, requestEntity, TokenResponse.class);
		 */
		/*
		 * System.out.println("coming-------"+ENDPOINT_AUTH_URL); return
		 * WebClient.create().get() .uri(ENDPOINT_AUTH_URL) .header("Authorization",
		 * "Bearer "+token) .retrieve() .bodyToMono(TokenResponse.class).map(s ->{
		 * 
		 * });
		 */
	}
}
