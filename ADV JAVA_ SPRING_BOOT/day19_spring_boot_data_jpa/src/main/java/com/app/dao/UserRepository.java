package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	//finder method pattern
	Optional<User> findByEmailAndPassword(String em,String pass);

}
