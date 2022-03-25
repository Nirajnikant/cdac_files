package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Topic;

@Repository
public class TopicDaoImpl implements ITopicDao {
	// dependency : SF
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Topic> getAllTopics() {
		String jpql = "select t from Topic t";
		return factory.getCurrentSession().createQuery(jpql, Topic.class).getResultList();

	}

}
