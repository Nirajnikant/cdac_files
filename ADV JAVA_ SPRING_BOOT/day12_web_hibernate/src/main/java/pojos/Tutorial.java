package pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial extends BaseEntity {
	// id | name | author | publish_LocalDate | visits | contents | topic_id
	@Column(name = "name")
	private String tutorialName;
	private String author;
	@Column(name = "publish_Date")
	private LocalDate publishDate;
	private int visits;
	private String contents;
	// uniDirectional association : Tutorial *--->1 Topic
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;// FK ---> PK of the topics table (topic)

	public Tutorial() {
		// TODO Auto-generated constructor stub
	}

	public Tutorial(int tutorialId, String tutorialName, String author, LocalDate publishDate, int visits,
			String contents, Topic topic) {
		super();
//		this.tutorialId = tutorialId;
		this.tutorialName = tutorialName;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.topic = topic;
		this.contents = contents;
	}

	public String getTutorialName() {
		return tutorialName;
	}

	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishLocalDate) {
		this.publishDate = publishLocalDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + getId() + ", tutorialName=" + tutorialName + ", author=" + author
				+ ", publishDate=" + publishDate + ", visits=" + visits;
	}

}
