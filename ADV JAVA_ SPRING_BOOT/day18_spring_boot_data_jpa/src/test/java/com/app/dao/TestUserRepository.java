package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.User;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestUserRepository {
	@Autowired
	private UserRepository repo;

	@Test
//	@Rollback(false)
	void test() {
		Optional<User> user = repo.findByEmailAndPassword("rama@gmail.com", "1234");
		System.out.println(user.get());
		
	}

}
