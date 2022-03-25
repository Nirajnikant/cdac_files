//package com.app.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.app.pojos.Topic;
//import com.app.pojos.Tutorial;
//
//@Repository
//public class TutorialDaoImpl implements ITutorialDao {
//	// dependency : SF
//	@Autowired
//	private EntityManager manager;
//
//	@Override
//	public List<String> getTutorialsByTopicId(int topicId) {
//		String jpql = "select t.tutorialName from Tutorial t where t.topic.id =:id";
//		return manager.createQuery(jpql, String.class).setParameter("id", topicId).getResultList();
//	}
//
//	@Override
//	public Tutorial getUpdatedTutorialDetails(String tutName) {
//		String jpql = "select t from Tutorial t where t.tutorialName=:name";
//		Tutorial tutorial = manager.createQuery(jpql, Tutorial.class).setParameter("name", tutName).getSingleResult();
//		// => valid tutorial : PERSISTENT --modify the state
//		tutorial.setVisits(tutorial.getVisits() + 1);
//		return tutorial;
//	}
//
//	@Override
//	public String addNewTutorial(Tutorial tutorial, int topicId) {
//		String mesg = "Adding new tutorial failed!!!!!!!!!!";
//		Topic topic = manager.find(Topic.class, topicId);
//		if (topic != null) {
//			// => topic id valid
//			// establish uni dir link from tut---> topic
//			tutorial.setTopic(topic);
//			manager.persist(tutorial);
//			mesg = "New tutorial added under Topic " + topic.getTopicName() + " with ID " + tutorial.getId();
//		}
//		return mesg;
//	}
//}
