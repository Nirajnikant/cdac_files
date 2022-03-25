package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.User;

@Repository // mandatory anno to tell SC : following is spring bean , containing data access
			// logic (DAL)
//Activates exc transalation mechanism(sql exc --> hib exc ---> spring specific excs : un chked excs)
public class UserDaoImpl implements IUserDao {
	// dependency : SF
	@Autowired // => byType
	private SessionFactory sf;

	@Override
	public User authenticateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

}
