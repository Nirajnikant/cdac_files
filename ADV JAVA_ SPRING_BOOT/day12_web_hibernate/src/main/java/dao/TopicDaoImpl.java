package dao;

import pojos.Topic;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

public class TopicDaoImpl implements ITopicDao {

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = null;
		String jpql = "select t from Topics t";
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			topics = session.createQuery(jpql, Topic.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return topics;
	}

}
