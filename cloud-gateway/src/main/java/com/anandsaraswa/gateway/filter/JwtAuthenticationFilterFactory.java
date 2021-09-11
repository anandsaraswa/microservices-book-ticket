package com.anandsaraswa.gateway.filter;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import com.anandsaraswa.gateway.config.AuthorizedMapper;
import com.anandsaraswa.gateway.entity.AuthorizedPojo;
import com.anandsaraswa.gateway.exceptions.JwtTokenMalformedException;
import com.anandsaraswa.gateway.exceptions.JwtTokenMissingException;

import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class JwtAuthenticationFilterFactory
		extends AbstractGatewayFilterFactory<JwtAuthenticationFilterFactory.Config> {

	@Autowired
	private JwtUtil jwtUtil;

	public JwtAuthenticationFilterFactory() {
		super(Config.class);
	}

	String headerJWT;

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();

			final List<String> apiEndpoints = List.of("/secure/authenticate");

			Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
					.noneMatch(uri -> r.getURI().getPath().contains(uri));

			if (isApiSecured.test(request)) {
				HashMap<String,String> result = new HashMap<String, String>();
           
				if (!request.getHeaders().containsKey("Authorization")) {
					ServerHttpResponse response = exchange.getResponse();
					response.setStatusCode(HttpStatus.UNAUTHORIZED);
					return response.setComplete();
				}
				headerJWT = request.getHeaders().getOrEmpty("Authorization").get(0);

				if (headerJWT != null && headerJWT.startsWith("Bearer ")) {
					headerJWT = headerJWT.substring(7);
					try {
						jwtUtil.validateToken(headerJWT);
					} catch (JwtTokenMalformedException | JwtTokenMissingException e) {
						ServerHttpResponse response = exchange.getResponse();
					     result.put("status", HttpStatus.UNAUTHORIZED.value()+"");
			             result.put("message", e.getMessage());
			             JSONObject jsonRes = new JSONObject(result);
						DataBuffer bodyDataBuffer = response.bufferFactory().wrap(jsonRes.toJSONString().getBytes());
						return response.writeWith(Mono.just(bodyDataBuffer));
					}
				String role =	jwtUtil.getClaims(headerJWT).get("scopes",String.class);
				
				if(AuthorizedMapper.authorizedMap.get(new AuthorizedPojo(request.getURI().getPath(), request.getMethod().name())) !=  null 
						&& !role.equals(AuthorizedMapper.authorizedMap.get(new AuthorizedPojo(request.getURI().getPath(), request.getMethod().name())))) {
					ServerHttpResponse response = exchange.getResponse();
					
					result.put("status", HttpStatus.UNAUTHORIZED.value()+"");
		            result.put("message","You are not authorized to access this resource");
		            JSONObject jsonRes = new JSONObject(result);
					DataBuffer bodyDataBuffer = response.bufferFactory().wrap(jsonRes.toJSONString().getBytes(StandardCharsets.UTF_8));
					return response.writeWith(Mono.just(bodyDataBuffer));
				}
				}
			}
			return chain.filter(exchange);
		};
	}
	

	public static class Config {
		// Put the configuration properties
	}

}
