package com.movie.bookshowonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.movie.bookshowonline.model.User;
import com.movie.bookshowonline.service.SignInService;

@CrossOrigin
@RestController
public class RegisterUserController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterUserController.class);

	@Autowired
	SignInService signInService;

	@PostMapping("/signin")
	public String signIn(@RequestBody User user) {

		logger.info("Entered Controller ; UserId : {}", user.getFirstName());

		String message = signInService.signIn(user);

		logger.info("Exiting Controller ; UserId : {}", user.getFirstName());

		return message;

	}

}
