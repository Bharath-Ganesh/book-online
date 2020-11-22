package com.movie.bookshowonline.serviceimpl;

import org.springframework.stereotype.Service;

import com.movie.bookshowonline.model.User;
import com.movie.bookshowonline.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Override
	public String signUp(User user) {

		return user.getFirstName() + " registered successfully";
	}

}
