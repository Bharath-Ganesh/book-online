package com.movie.bookshowonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookshowonline.model.User;
import com.movie.bookshowonline.service.SignUpService;

@CrossOrigin
@RestController
public class SignUpController {

	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);

	@Autowired
	SignUpService signUpService;

	@PostMapping("/signup")
	public String signUp(@RequestBody User user) {

		logger.info("Entered SignUpController ; UserId : {}", user.getFirstName());

		String message = signUpService.signUp(user);

		logger.info("Exited SignUpController ; UserId : {}", user.getFirstName());

		return message;

	}

}
