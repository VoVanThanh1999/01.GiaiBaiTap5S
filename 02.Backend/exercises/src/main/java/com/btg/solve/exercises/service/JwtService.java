package com.btg.solve.exercises.service;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {
	String extractUserName(String token) throws Exception;

	String generateToken(UserDetails userDetails) throws Exception;

	boolean isTokenValid(String token, UserDetails userDetails) throws Exception;
}
