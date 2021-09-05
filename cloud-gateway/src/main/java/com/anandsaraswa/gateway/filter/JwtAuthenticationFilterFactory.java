package com.anandsaraswa.gateway.filter;

import java.util.List;
import java.util.function.Predicate;

import javax.xml.bind.DatatypeConverter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtAuthenticationFilterFactory extends AbstractGatewayFilterFactory<JwtAuthenticationFilterFactory.Config> {

	private String SECRET_KEY = "secret";
	
	public JwtAuthenticationFilterFactory() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		  return (exchange, chain) -> {
				ServerHttpRequest request = exchange.getRequest();

				final List<String> apiEndpoints = List.of("/secure/authenticate");

				Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
						.noneMatch(uri -> r.getURI().getPath().contains(uri));

				if (isApiSecured.test(request)) {
					if (!request.getHeaders().containsKey("Authorization")) {
						ServerHttpResponse response = exchange.getResponse();
						response.setStatusCode(HttpStatus.UNAUTHORIZED);

						return response.setComplete();
					}
					String headerJWT = request.getHeaders().getOrEmpty("Authorization").get(0);
					
					if(headerJWT != null && headerJWT.startsWith("Bearer ")) {
						headerJWT =  headerJWT.substring(7);
						//username = jwtUtil.extractUsername(jwt);
					}
					
					System.out.println("token----"+headerJWT);
					Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				       .parseClaimsJws(headerJWT).getBody();
					System.out.println("token----get");
					Claims claims = getClaims(headerJWT);
					exchange.getRequest().mutate().header("id", String.valueOf(claims.get("id"))).build();
				
			}
				return chain.filter(exchange);
};
	}
	
	public Claims getClaims(final String token) {
		try {
			System.out.println("getclaims-------------------");
			Claims body = Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				       .parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}
	
	public static class Config {
		// Put the configuration properties
	}


}
