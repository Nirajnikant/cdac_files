package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Topic;
import com.app.pojos.Tutorial;
import org.hibernate.SessionFactory;

@Repository
public class TutorialDaoImpl implements ITutorialDao {
	// dependency : SF
	@Autowired
	private SessionFactory sf;

	@Override
	public List<String> getTutorialsByTopicId(int topicId) {
		String jpql = "select t.tutorialName from Tutorial t where t.topic.id =:id";
		return sf.getCurrentSession().createQuery(jpql, String.class).setParameter("id", topicId).getResultList();
	}

	@Override
	public Tutorial getUpdatedTutorialDetails(String tutName) {
		String jpql = "select t from Tutorial t where t.tutorialName=:name";
		Tutorial tutorial = sf.getCurrentSession().createQuery(jpql, Tutorial.class).setParameter("name", tutName)
				.getSingleResult();
		// => valid tutorial : PERSISTENT --modify the state
		tutorial.setVisits(tutorial.getVisits() + 1);
		return tutorial;
	}

	@Override
	public String addNewTutorial(Tutorial tutorial, int topicId) {
		String mesg = "Adding new tutorial failed!!!!!!!!!!";
		Session session = sf.getCurrentSession();
		Topic topic = session.get(Topic.class, topicId);
		if (topic != null) {
			// => topic id valid
			// establish uni dir link from tut---> topic
			tutorial.setTopic(topic);
			session.persist(tutorial);
			mesg = "New tutorial added under Topic " + topic.getTopicName() + " with ID " + tutorial.getId();
		}
		return mesg;
	}
}
