package com.xyz.user.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xyz.user.entity.User;
import com.xyz.user.entity.request.UserRegistrationRequest;
import com.xyz.user.entity.response.UserResponse;
import com.xyz.user.repository.UserRepository;
import com.xyz.user.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	private static final Logger logger = LoggerFactory.getLogger(UserRegisterServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	public User convertIntoEntity(UserRegistrationRequest userRegReq) {
		User user = new User();
		user.setAddress(userRegReq.getAddress());
		user.setEmail_id(userRegReq.getEmailId());
		user.setUsername(userRegReq.getUsername());
		user.setPassword(userRegReq.getPassword());
		return user;

	}

	@Override
	public UserResponse registerUser(UserRegistrationRequest userRegReq) {
		// TODO Auto-generated method stub
		UserResponse userResponse = null;
		if (null != userRegReq) {

			if (null != userRegReq.getConfirmPassword() && null != userRegReq.getConfirmPassword()) {

				if (userRegReq.getConfirmPassword().equals(userRegReq.getConfirmPassword())) {
					String username = userRegReq.getUsername();
					userResponse = new UserResponse();
					Optional<User> userExist = userRepository.findByUsername(username);
					if (userExist.isEmpty()) {
						User user = convertIntoEntity(userRegReq);
						try {
							userRepository.save(user);
							userResponse.setMessage("User created successfully");
						} catch (Exception ex) {
							logger.info("Caught Exception while saving into database", ex);
							userResponse.setMessage("Something Went Wrong");
						}

					} else {
						userResponse.setMessage("User already registered. Please login to continue");
					}
				}

			}

		}
		return userResponse;
	}

}
