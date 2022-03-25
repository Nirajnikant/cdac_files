package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;
import pojos.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public User authenticateUser(String email, String password) {
		User u = null; 
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			u = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return u;
	}

}
