package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

public class TutorialBean {
	// state
	private int topicId;
	private String tutName;
	private String author;
	private String pubDate;
	private String contents;
	private String message;

	// dependecy :: dao layer -- tutorial dao
	private TutorialDaoImpl tutDao;

	// def constructor
	public TutorialBean() throws SQLException {
		System.out.println("in tut bean COnstructor");
		// create instance of tutorial dao
		tutDao = new TutorialDaoImpl();
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTutName() {
		return tutName;
	}

	public void setTutName(String tutName) {
		this.tutName = tutName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public TutorialDaoImpl getTutDao() {
		return tutDao;
	}

	public void setTutDao(TutorialDaoImpl tutDao) {
		this.tutDao = tutDao;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	// add Business logic method to validate tutorials details and add record
	public String validateAddTutorial() throws SQLException {
		System.out.println("in business Logic method "+ author);
		LocalDate date = LocalDate.parse(pubDate);
		// validation
		int months = (int)Period.between(date, LocalDate.now()).toTotalMonths();
		if(contents.length() < 255 & months < 6) {
			// validation success --> procced to insertion of a record
			
			// invoke dao's method
			message = tutDao.addNewTutorial(new Tutorial(tutName, author, Date.valueOf(date), contents, topicId));
			return "logout";
		}
		else { 
			message = "validation constraints failure!!!!!!!";
			return "add_new_tut";
		}
	}
}














