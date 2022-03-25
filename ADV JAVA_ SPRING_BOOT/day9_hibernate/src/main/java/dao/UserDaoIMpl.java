package dao;

import pojo.User;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class UserDaoIMpl implements IUserDao {
	
	String mesg;
	
	@Override
	public String registerUser(User user) {
		// get Session from SessionFactory
		Session session = getFactory().openSession();
		// begin the transaction
		Transaction tx = session.beginTransaction();
		try {
			// Session API : public Serializable save(Object transientPOJORef) throws HibernateExc
			session.save(user);
			// end of try block : success
			tx.commit();
			mesg = "user registred successfull" + user.getUserId();
		} catch (RuntimeException e) {
			// tx : failure --> rollback the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to caller : to inform about the failure
			throw e;
		} finally {
			// close the session explicitly so that pooled out DB connection return to the pool
			if(session != null)
				session.close();
		}
		return mesg;
	}

}
