package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;

public class TopicDaoImpl implements ITopicDao {

	@Override
	public List<Topic> getAllTopics() {
		List<Topic>topics=null;
		String jpql="select t from Topic t";
		// get Session from SF
				Session session=getFactory().getCurrentSession();
				//begin tx
				Transaction tx=session.beginTransaction();
				try {
					topics=session.createQuery(jpql, Topic.class).getResultList();
					tx.commit();
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					throw e;
				}
		return topics;
	}

}
