package com.xyz.user.service;

import com.xyz.user.entity.request.UserLoginRequest;
import com.xyz.user.entity.response.UserResponse;

public interface UserLoginInService {

	UserResponse loginIn(UserLoginRequest userLoginRequest);

}
