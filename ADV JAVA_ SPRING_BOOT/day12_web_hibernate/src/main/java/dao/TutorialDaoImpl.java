package dao;

import static utils.HibernateUtils.getFactory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Topic;
import pojos.Tutorial;

public class TutorialDaoImpl implements ITutorialDao {

	@Override
	public List<String> getTutorialsByTopicId(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateVisits(String tutName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNewTutorial(Tutorial tutorial, int topicId) {
		String mesg = "Adding new Tutorial failed";
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			// get topic from topic Id
			Topic topic = session.get(Topic.class, topicId);
			if (topic != null) {
				// topic id valid
				// establish unidirectional link from tutorial ---> topic
				tutorial.setTopic(topic);
				session.persist(tutorial);
				mesg = "New tutorial added under Topic "+ topic.getTopicName()+"with ID "+tutorial.getId();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
