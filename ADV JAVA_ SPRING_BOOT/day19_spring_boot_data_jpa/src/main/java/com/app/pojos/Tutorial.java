package com.app.pojos;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tutorials")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tutorial extends BaseEntity{
	//id | name        | author | publish_date | visits | contents | topic_id
	@Column(name="name")
	private String tutorialName;
	private String author;
	@Column(name="publish_date")
	private LocalDate publishDate;
	private int visits;
	private String contents;
	//uni dir asso Tutorial *-->1 Topic
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id",nullable = false)
	private Topic topic;
	
//	public Tutorial() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	
//	public String getTutorialName() {
//		return tutorialName;
//	}
//	public void setTutorialName(String tutorialName) {
//		this.tutorialName = tutorialName;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//	
//	public LocalDate getPublishDate() {
//		return publishDate;
//	}
//
//	public void setPublishDate(LocalDate publishDate) {
//		this.publishDate = publishDate;
//	}
//
//	public int getVisits() {
//		return visits;
//	}
//	public void setVisits(int visits) {
//		this.visits = visits;
//	}
//	
//	
//	public Topic getTopic() {
//		return topic;
//	}
//
//
//
//	public void setTopic(Topic topic) {
//		this.topic = topic;
//	}
//
//
//
//	public String getContents() {
//		return contents;
//	}
//
//	public void setContents(String contents) {
//		this.contents = contents;
//	}
//
//	@Override
//	public String toString() {
//		return "Tutorial [tutorialId=" +getId() + ", tutorialName=" + tutorialName + ", author=" + author
//				+ ", publishDate=" + publishDate + ", visits=" + visits ;
//	}
	
	

}
