package com.btg.solve.exercises.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Home {

	@RequestMapping("/oauth2Success")
	public String simpleRequest(HttpServletResponse response) {
		// Get the username of the currently logged in user
		// this method is defined below
		Optional<String> username = getUsernameFromSecurityContext();
		if (username.isEmpty()) {
			// if user information cannot be obtained, return
			// a 403 status
			response.setStatus(HttpStatus.FORBIDDEN.value());
			return "error";
		}

		// show the welcome messages with the users Github username
		return "welcome " + username.get();
	}

	private Optional<String> getUsernameFromSecurityContext() {
		// Get the security context for this request thread
		// and get the principal object from the context
		SecurityContext context = SecurityContextHolder.getContext();
		Object principal = context.getAuthentication().getPrincipal();

		// If the user is authenticated, the principal should be an
		// instance of DefaultOAuth2User
		if (!(principal instanceof OAuth2User)) {
			// if not, return an empty value
			return Optional.empty();
		}

		// Get the username from the DefaultOAuth2User and return
		// the welcome message
		String username = ((OAuth2User) principal).getAttributes().get("login").toString();
		return Optional.of(username);
	}

}
