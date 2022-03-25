package daoTutorials;

import java.util.List;
import pojos.Tutorials;
import java.sql.SQLException;

public interface ITutorialDao {
	List<String> getAllTutorials() throws SQLException;
	Tutorials getTutorialDetail(String tutorialName) throws SQLException;
	String updateVisits(int id) throws SQLException;
}