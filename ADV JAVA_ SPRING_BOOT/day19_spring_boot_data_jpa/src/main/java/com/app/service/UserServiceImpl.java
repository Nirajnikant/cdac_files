package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.pojos.User;

@Service // MANDATORY to tell SC : following is spring bean , containing B.L
@Transactional // annotation meant for SC , to automatically manage txs
//(begin tx ---call dao layer method --success --commit OR in case of failure --> rollback )
public class UserServiceImpl implements IUserService {
	// dependency : DAO layer i/f
	@Autowired // autowire=byType
	private UserRepository userDao;

	@Override
	public User authenticateUser(String email, String password) {
	
		// TODO Auto-generated method stub
//		 Optional<User> optional = userDao.findByEmailAndPassword(email, password);
//		 if(optional.isPresent())
//			 return optional.get();
//		 return null;
		return userDao.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("Invalid Credentials!!!!!"));
	}

}
