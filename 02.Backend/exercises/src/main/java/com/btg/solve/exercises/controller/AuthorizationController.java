package com.btg.solve.exercises.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
	private static final Logger logger = LogManager.getLogger(AuthorizationController.class);

	@GetMapping("/{id}")
	public ResponseEntity<String> sayHello(@PathVariable int id) throws Exception {
		logger.info("1");
		throw new Exception("121");
	}
}
