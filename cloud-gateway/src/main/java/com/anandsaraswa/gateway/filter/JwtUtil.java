package com.anandsaraswa.gateway.filter;



import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.anandsaraswa.gateway.exceptions.JwtTokenMalformedException;
import com.anandsaraswa.gateway.exceptions.JwtTokenMissingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {

	private String SECRET_KEY = "secret";

	public Claims getClaims(final String token) {
		try {
			return Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				       .parseClaimsJws(token).getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void validateToken(final String token) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			 
			Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				       .parseClaimsJws(token).getBody();
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException("Token is in malform please login again");
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("Token has been expired, please login again");
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException("Unsupported");
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException("Illegal arguement in jwt token");
		}
	}

}