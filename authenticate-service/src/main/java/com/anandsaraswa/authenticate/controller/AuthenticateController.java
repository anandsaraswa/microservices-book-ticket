package com.anandsaraswa.authenticate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anandsaraswa.authenticate.entity.AuthenticateRequest;
import com.anandsaraswa.authenticate.entity.AuthenticateResponse;
import com.anandsaraswa.authenticate.entity.Users;
import com.anandsaraswa.authenticate.jwt.JwtUtil;
import com.anandsaraswa.authenticate.service.UserService;

@RestController
@RequestMapping("/secure")
public class AuthenticateController {
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtils;

	@PostMapping("/authenticate")
	public AuthenticateResponse authenticate(@RequestBody AuthenticateRequest authenticateRequest)
			throws BadCredentialsException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticateRequest.getUsername(), authenticateRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect username or password");

		}

		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(),
						authenticateRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String jwt = this.jwtUtils.generateToken(authentication);
		return new AuthenticateResponse(jwt);
	}

	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.findAll();
	}
	
	
}
