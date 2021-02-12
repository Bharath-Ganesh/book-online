package com.xyz.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.user.entity.request.UserLoginRequest;
import com.xyz.user.entity.response.UserResponse;
import com.xyz.user.service.UserLoginInService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.*;

@CrossOrigin
@Api(value = "Login Controller")
@RestController
@RequestMapping("/user")
public class UserLoginController {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@Autowired
	UserLoginInService loginInService;

	@ApiOperation(value = "Login as a user", notes = "This method allows a user login", response = UserResponse.class)
	@PostMapping("/login")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Page not found"),
			@ApiResponse(code = 200, message = "User login successful", response = UserResponse.class) })
	public ResponseEntity<UserResponse> loginIn(@RequestBody UserLoginRequest userLoginRequest) {

		logger.info("Entered UserLoginController ; Username : {} ", userLoginRequest.getUsername());
		UserResponse userResponse = loginInService.loginIn(userLoginRequest);
		logger.info("Exited UserLoginController ; Username : {} ", userLoginRequest.getUsername());
		
		return new ResponseEntity<>(userResponse, HttpStatus.OK);

	}

}
