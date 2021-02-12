package com.xyz.user.service;

import com.xyz.user.entity.request.UserRegistrationRequest;
import com.xyz.user.entity.response.UserResponse;

public interface UserRegisterService {

	public UserResponse registerUser(UserRegistrationRequest userRegReq);

}
