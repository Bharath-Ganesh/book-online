package com.xyz.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xyz.user.entity.request.UserRegistrationRequest;
import com.xyz.user.entity.response.UserResponse;
import com.xyz.user.service.UserRegisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@Api(value = "Registration Controller")
@RestController
@RequestMapping("/user")
public class UserRegisterController {

	private static final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

	@Autowired
	private UserRegisterService userRegisterService;

	@ApiOperation(value = "Registration for an admin or agent", response = UserResponse.class)
	@PostMapping("/register")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Page not found"),
			@ApiResponse(code = 200, message = "User registered successful", response = UserResponse.class) })
	public UserResponse registerUser(@RequestBody UserRegistrationRequest userRegReq) {

		logger.info("Entered UserRegisterController , {}", userRegReq.getUsername());

		UserResponse userResponse = userRegisterService.registerUser(userRegReq);

		logger.info("Exited UserRegisterController ; {}", userRegReq.getUsername());

		return userResponse;

	}

}
