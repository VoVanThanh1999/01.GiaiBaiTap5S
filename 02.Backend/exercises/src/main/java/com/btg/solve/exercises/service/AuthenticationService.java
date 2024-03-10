package com.btg.solve.exercises.service;

import com.btg.solve.exercises.dto.request.SignUpRequest;
import com.btg.solve.exercises.dto.request.SigninRequest;
import com.btg.solve.exercises.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
	JwtAuthenticationResponse signup(SignUpRequest request) throws Exception;

	JwtAuthenticationResponse signin(SigninRequest request) throws Exception;
}
