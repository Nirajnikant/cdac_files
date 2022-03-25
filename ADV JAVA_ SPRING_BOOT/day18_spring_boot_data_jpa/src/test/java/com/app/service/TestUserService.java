package com.app.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.User;

@SpringBootTest
class TestUserService {
	@Autowired
	private IUserService userService;

	@Test
	void test() {
		User user = userService.authenticateUser("rama@gmail.com", "1234");
		System.out.println("user "+user);
		assertEquals(1500, user.getRegAmount());
	}

}
