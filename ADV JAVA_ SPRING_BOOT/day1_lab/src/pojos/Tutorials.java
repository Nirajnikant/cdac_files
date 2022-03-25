package pojos;

import java.sql.Date;

public class Tutorials {
	// | id | name | author | publish_date | visits | contents | topic_id
	private int id;
	private String name;
	private String author;
	private Date publishDate;
	private int visits;
	private String contents;
	private int topicId;
	
	public Tutorials() {
		
	}

	public Tutorials(int id, String name, String author, Date publishDate, int visits, String contents, int topicId) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.contents = contents;
		this.topicId = topicId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	@Override
	public String toString() {
		return "Tutorials [id=" + id + ", name=" + name + ", author=" + author + ", publishDate=" + publishDate
				+ ", visits=" + visits + ", contents=" + contents + ", topicId=" + topicId + "]";
	}
	

}