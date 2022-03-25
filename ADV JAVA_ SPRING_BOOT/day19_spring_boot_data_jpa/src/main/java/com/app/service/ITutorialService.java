package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {
//add a method to get list of tut names by a selected topic id
	List<String> getTutorialNames(int topicId);
	//add a method to get updated(visits) tut contents
	Tutorial getUpdatedTutorialContents(String tutName);
	//add a new method to insert tutorial details
	String addNewTutorial(Tutorial tutorial,int topicId);
}
