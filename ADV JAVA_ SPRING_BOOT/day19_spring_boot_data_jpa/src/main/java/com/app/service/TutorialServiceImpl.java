package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.TopicRepository;
import com.app.dao.TutorialRepository;
import com.app.pojos.Topic;
import com.app.pojos.Tutorial;

@Service
@Transactional
public class TutorialServiceImpl implements ITutorialService {
	@Autowired
	private TutorialRepository tutorialRepo;

	@Autowired
	private TopicRepository topicRepo;

	@Override
	public List<String> getTutorialNames(int topicId) {
		return tutorialRepo.getTutorialsByTopicId(topicId);
	}

	@Override
	public Tutorial getUpdatedTutorialContents(String tutName) {
		// get existing tut contents by it's name
		Tutorial tutorial = tutorialRepo.findByTutorialName(tutName)
				.orElseThrow(() -> new RuntimeException("Invalid tut name!!!!!!!!!"));
		// =>tutorial found : PERSISTENT
		tutorial.setVisits(tutorial.getVisits() + 1);// updated state of persistent
		return tutorial;
	} // session.flush --auto dirty chking ---update --sesison closed : rets a
		// detached pojo

	@Override
	public String addNewTutorial(Tutorial tutorial, int topicId) {
		// get topic details from topic id
		Topic topic = topicRepo.findById(topicId).orElseThrow(() -> new RuntimeException("Invalid topic id!!!!!!!!!!"));
		// establish uni dir asso from tut ---> topic
		tutorial.setTopic(topic);
		Tutorial tutorial2 = tutorialRepo.save(tutorial);
		return "Added new tutorial with id=" + tutorial2.getId();
	}

}
