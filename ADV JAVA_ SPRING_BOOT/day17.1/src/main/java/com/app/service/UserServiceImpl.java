package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service //MANDATORY to tell SC : following is spring bean , containing B.L 
@Transactional //annotation meant for SC , to automatically manage txs 
//(begin tx ---call dao layer method --success --commit OR in case of failure --> rollback )
public class UserServiceImpl implements IUserService {
	//dependency : DAO layer i/f
	@Autowired //autowire=byType
	private IUserDao userDao;

	@Override
	public User authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.authenticateUser(email, password);
	}

}
