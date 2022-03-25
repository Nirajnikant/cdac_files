package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TopicRepository;
import com.app.pojos.Topic;

@Service
@Transactional
public class TopicServiceImpl implements ITopicService {
	//dep : topic repo
	@Autowired
	private TopicRepository topicRepo;
	

	@Override
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		return topicRepo.findAll();
	}

}
