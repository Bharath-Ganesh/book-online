package com.movie.bookshowonline.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.movie.bookshowonline.service.SignInService;

@Service
public class SignInServiceImpl implements SignInService {

	@Override
	public String signIn(String userId, String password) {
		

		Map<String, String> userCredentialsMap = new HashMap<>();
		userCredentialsMap.put("userId1", "password1");
		userCredentialsMap.put("userId2", "password2");
		userCredentialsMap.put("userId3", "password3");
		String message = "";

		for (Map.Entry<String, String> entry : userCredentialsMap.entrySet()) {
			message = "Please Re-enter your credentials";
			if (entry.getKey().equalsIgnoreCase(userId)) {
				if (entry.getValue().equals(password)) {
					message = "Signed In Successfully";
					break;
				}
			}

		}

		return message;
	}

}