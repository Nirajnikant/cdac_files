//package com.app.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.app.pojos.Topic;
//
//@Repository
//@Transactional
//public class TopicDaoImpl implements ITopicDao {
//	// dependency : javax.persistence.EntityManager
//	@Autowired
//	private EntityManager mgr;
//
//	@Override
//	public List<Topic> getAllTopics() {
//		String jpql = "select t from Topic t";
//		return mgr.createQuery(jpql, Topic.class).getResultList();
//
//	}
//
//}
