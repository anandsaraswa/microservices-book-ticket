package com.anandsaraswa.authenticate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateServiceApplication.class, args);
	}

}
