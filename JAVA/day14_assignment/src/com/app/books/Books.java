package com.app.books;

import java.time.LocalDate;


public class Books {
//	Book details : title(string),category(enum),price(double),publishDate(LocalDate) ,authorName(string),quantity(int)
//	Unique ID : book title
	private String title;
	public enum Category {
		FICTION, NONFICTION, BIOGRAPHY, AUTOBIOGRAPHY;
	}
	private double price;
	private LocalDate publishDate;
	private String authorName;
	private int quantity;
	private Category type;

	public Books(String title, double price, LocalDate publishDate, String authorName, int quantity, Category category) {
		super();
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.quantity = quantity;
		this.type = category;
	}

	public Books(String title) {
		super();
		this.title = title;
	}

	@Override
	public String toString() {
		return "Books [title=" + title + ", price=" + price + ", publishDate=" + publishDate + ", authorName="
				+ authorName + ", quantity=" + quantity + ", type=" + type + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("in books equals");
		if(o instanceof Books) {
			Books e = (Books) o;
			//rather than making it single field based unique identity we are making multi field based
			return title.equals(e.title);
			
		}
		return false;
			
	}
	
	@Override
	public int hashCode() {
		System.out.println("in emp's hashCode");
//		whatever unique keys you used in generating the equals method will be used for hashcode
		return 17*(title.hashCode());//random formula
//		adding prime no. in multiplication improves the performance and ensures separation or uniform distribution of data in buckets 
	}
}
