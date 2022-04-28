package com.springboot.ConsentManagement.JWT;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	
	private final AuthenticationManager authenticationManager;
	
	public JWTUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		
		try {
			// Fetching the credentials from api
			UsernameAndPasswordRequest credentials =  new ObjectMapper().
					readValue(request.getInputStream(), UsernameAndPasswordRequest.class);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					credentials.getUsername(), credentials.getPassword());
			
			System.out.println(credentials.getPassword());
			// Validator to verify the credentials;
			return authenticationManager.authenticate(authentication);
		} 
		catch (IOException e) {
			throw new RuntimeException(e);
		}	
	}

	// This is called once the user is authenticated.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		// Generating token with given credentials and authorities.
		String key = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";
		String token = Jwts.builder()
			.setSubject(authResult.getName())
			.claim("authorities", authResult.getAuthorities())
			.setIssuedAt(new Date())
			.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(2)))
			.signWith(Keys.hmacShaKeyFor(key.getBytes()))
			.compact();
		
		response.addHeader("Authorization", "Bearer " + token);
		
	}
	
	
	
}
