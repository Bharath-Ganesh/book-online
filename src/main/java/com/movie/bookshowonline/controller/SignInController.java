package com.movie.bookshowonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookshowonline.service.SignInService;

@CrossOrigin
@RestController
//Sign In Controller
public class SignInController {

	private static final Logger logger = LoggerFactory.getLogger(SignInController.class);

	@Autowired
	SignInService signInService;

	@GetMapping("/signin/{userId}/{password}")
	public String signIn(@PathVariable String userId,@PathVariable String password) {

		logger.info("Entered SignInController ; UserId : {} ", userId);

		String message = signInService.signIn(userId,password);

		logger.info("Exited SignInController ; UserId : {} ", userId);

		return message;

	}

}
