package com.xyz.user.serviceimpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xyz.user.entity.User;
import com.xyz.user.entity.request.UserLoginRequest;
import com.xyz.user.entity.response.UserResponse;
import com.xyz.user.repository.UserRepository;
import com.xyz.user.service.UserLoginInService;

@Service
public class UserLoginServiceImpl implements UserLoginInService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponse loginIn(UserLoginRequest userLoginRequest) {

		UserResponse userResponse = null;
		if (null != userLoginRequest) {

			if (userLoginRequest.getUsername() != null) {
				Optional<User> userExist = userRepository.findByUsername(userLoginRequest.getUsername());
				userResponse = new UserResponse();
				if (userExist.isEmpty()) {

					userResponse.setMessage("Authentication failed. User not found");
				} else {
					userResponse.setMessage("Login successfully");
				}
			}

		}
		return userResponse;

	}

}

/*
 * Before establishing the database connection
 */

//Map<String, String> userCredentialsMap = new HashMap<>();
//userCredentialsMap.put("userId1", "password1");
//userCredentialsMap.put("userId2", "password2");
//userCredentialsMap.put("userId3", "password3");
//String message = "";
//
//for (Map.Entry<String, String> entry : userCredentialsMap.entrySet()) {
//	message = "Please Re-enter your credentials";
//	if (entry.getKey().equalsIgnoreCase(userId)) {
//		if (entry.getValue().equals(password)) {
//			message = "Signed In Successfully";
//			break;
//		}
//	}
//
//}