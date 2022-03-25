package dao;

import pojo.Role;
import pojo.User;
import java.util.List;
import org.hibernate.*;
import java.time.LocalDate;
import static utils.HibernateUtils.getFactory;

public class UserDaoIMpl implements IUserDao {

	String mesg;

	@Override
	public String registerUser(User user) {
		// user : not associated with L1 cache, no DB identity, exists only in java heap
		// : TRANSIENT
		// get Session from SessionFactory
		Session session = getFactory().openSession();
		Session session2 = getFactory().openSession();
		System.out.println(session == session2); // false
		System.out.println("is session open " + session.isOpen() + " is connected to db " + session.isConnected());
		// begin the transaction
		Transaction tx = session.beginTransaction();// L1 cache created : EMPTY --- cache of persistance pojo ref'
		try {
			// Session API : public Serializable save(Object transientPOJORef) throws
			// HibernateExc
			session.save(user);// user : PERSISTENT (associated with L1 cache, BUT NT YET DB)
			// end of try block : success
			tx.commit();// session.flush --> Hibernate performs "Automatic dirty checking", upon commit
						// --> synchronize state of L1 cache with DB
						// and invokes/fires DML(insert)
			mesg = "user registred successfull" + user.getUserId();
		} catch (RuntimeException e) {
			// tx : failure --> rollback the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to caller : to inform about the failure
			throw e;
		} finally {
			System.out.println("is session open " + session.isOpen() + " is connected to db " + session.isConnected()); // true
																														// true
			// close the session explicitly so that pooled out DB connection return to the
			// pool
			if (session != null)
				session.close();// L1 cache destroyed
		}

		System.out.println("is session open " + session.isOpen() + " is connected to db " + session.isConnected()); // false
																													// false
		// user : dis associated with L1 cache, BUT has DB identity : DETACHED
		return mesg;
	}

	@Override
	public String registerUserWithCurrentSession(User user) {
		// user : not associated with L1 cache, no DB identity, exists only in java heap
		// : TRANSIENT
		// get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		Session session2 = getFactory().getCurrentSession();
		System.out.println(session == session2); // true

		// begin the transaction
		Transaction tx = session.beginTransaction();// L1 cache created : EMPTY --- cache of persistance pojo ref'
		System.out.println("is session open " + session.isOpen() + " is connected to db " + session.isConnected()); // true
																													// true

		try {
			// Session API : public Serializable save(Object transientPOJORef) throws
			// HibernateExc
			session.save(user);// user : PERSISTENT (associated with L1 cache, BUT NT YET DB)
			// end of try block : success
			tx.commit();// session.flush --> Hibernate performs "Automatic dirty checking", upon commit
						// --> synchronize state of L1 cache with DB
						// and invokes/fires DML(insert)
			mesg = "user registred successfull" + user.getUserId();
		} catch (RuntimeException e) {
			// tx : failure --> rollback the tx
			if (tx != null)
				tx.rollback();
			System.out.println("is session open " + session.isOpen() + " is connected to db " + session.isConnected());
			// re throw the same exception to caller : to inform about the failure
			throw e;
		}

		System.out.println("is session open " + session.isOpen() + " is connected to db " + session.isConnected()); // false
																													// false
		// user : dis associated with L1 cache, BUT has DB identity : DETACHED
		return mesg;
	}

	@Override
	public User findByUser(int userId) {
		User user = null; // user : state : Not Applicable
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			// API og org.hibernate.Session
			// public <T> T get(Class<T> class, Serializable id) throws HibExc
			user = session.get(User.class, userId); // user != null => user : PERSISTENT
			user = session.get(User.class, userId); // user != null => user : PERSISTENT
			user = session.get(User.class, userId); // user != null => user : PERSISTENT
			user = session.get(User.class, userId); // user != null => user : PERSISTENT
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user; // user state : DETACHED
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		String jpql = "select u from User u";
		// ^^pojo alias || pojo ref name
		// get session from sesionFactory : get current Session
		Session session = getFactory().getCurrentSession();
		// begin transaction
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList(); // users : list of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;// users : list of DETACHED entities
	}

	@Override
	public List<User> getSelectedUsers(LocalDate startDate, LocalDate endDate, Role userRole) {
		List<User> users = null;
		String jpql = "select u from User u where u.regDate between :begin and :end and u.userRole=:role";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("begin", startDate).setParameter("end", endDate)
					.setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users; // list of detached pojos
	}

	@Override
	public List<String> getSelectedUserName(LocalDate startDate, LocalDate endDate, Role userRole) {
		List<String> userNames = null;
		String jpql = "select u.name from User u where u.regDate between :begin and :end and u.userRole=:role";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			userNames = session.createQuery(jpql, String.class).setParameter("begin", startDate)
					.setParameter("end", endDate).setParameter("role", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return userNames; // list of names of DETACHED pojos
	}

	@Override
	public List<User> getSelectedUserDetails(LocalDate startDate, LocalDate endDate, Role userRole) {
		List<User> users = null;
		String jpql = "select new pojo.User(name, email, regAmount, regDate) from User u where u.regDate between :begin and :end and u.userRole=:role";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("begin", startDate).setParameter("end", endDate)
					.setParameter("role", userRole).getResultList();
			tx.commit(); // session.flush() -- no changes -- no DMLs -- L1 cache is destroyed, pooled out
							// db connection to the pool -- session closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache is destroyed, pooled out db connection to the pool -- session closed
			throw e;
		}
		return users;
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		String mesg = "Pass word updation failed!!!!!";
		User users;
		// jpql for authentication
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", oldPwd)
					.getSingleResult();
			// => success : user : PERSISTENT entity
			// change the state of PERSISTENT entity : setter
			users.setPassword(newPwd); // changing the state of the persistent entity
			tx.commit(); // session.flush -- auto dirty checking -- update query .....
			mesg = "password CHANGED";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		users.setPassword("999999"); // user : DETACHED -- when state of detached entity is modified, hibernate
										// CANNOT perform any dirty checking : session is already closed
		return mesg;
	}
}