package com.movie.bookshowonline.serviceimpl;

import org.springframework.stereotype.Service;
import com.movie.bookshowonline.model.User;
import com.movie.bookshowonline.service.SignInService;

@Service
public class SignInServiceImpl implements SignInService{

	@Override
	public String signIn(User user) {
		
		return user.getFirstName() + " registered successfully";
	}

}
