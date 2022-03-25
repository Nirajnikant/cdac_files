package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
//get all tutorials under specified topic in a sorted as per visits manner
	// in absence of inherited suitable API or finder method , can create cuto query
	// method
	@Query(value = "select t.tutorialName from Tutorial t where t.topic.id=:tid order by t.visits desc")
	List<String> getTutorialsByTopicId(@Param("tid") int topicId);

//finder method pattern
	Optional<Tutorial> findByTutorialName(String tutName);

	// add new tutorial : using inherited API

}
