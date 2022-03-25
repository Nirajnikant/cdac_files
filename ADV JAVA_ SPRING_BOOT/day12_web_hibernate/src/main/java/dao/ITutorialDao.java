package dao;

import java.util.List;
import pojos.Tutorial;

public interface ITutorialDao {
	// get all tutorials under specified topic in a sorted as per visits manner
	List<String> getTutorialsByTopicId(int topicId);

	// get tutorial details
	Tutorial getTutorialDetails(String tutName);

	// update visits
	String updateVisits(String tutName);

	// add new tutorial
	String addNewTutorial(Tutorial tutorial, int topicId);
}