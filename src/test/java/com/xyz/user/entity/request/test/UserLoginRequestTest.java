package com.xyz.user.entity.request.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.xyz.user.entity.request.UserLoginRequest;

public class UserLoginRequestTest {

	@Test
	void testUserLoginRequest() {
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		userLoginRequest.setPassword("1234");
		userLoginRequest.setRole("ADMIN");
		userLoginRequest.setUsername("XYZ");
		assertEquals(userLoginRequest.getPassword(), "1234");
		assertEquals(userLoginRequest.getRole(), "ADMIN");
		assertEquals(userLoginRequest.getUsername(), "XYZ");
		assertNotNull(userLoginRequest);
	}

}
