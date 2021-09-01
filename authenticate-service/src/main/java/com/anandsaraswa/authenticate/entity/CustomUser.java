package com.anandsaraswa.authenticate.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser extends Users implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	public CustomUser(final Users user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 
//		 List<GrantedAuthority> authorities = user.getRoles().stream()
//					.map(role -> new SimpleGrantedAuthority(role.getName().name()))
//					.collect(Collectors.toList());
		 
		   
		 authorities.add(new SimpleGrantedAuthority(getRole()));
	//	 authorities.add(new SimpleGrantedAuthority("ADMIN"));
		 return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
