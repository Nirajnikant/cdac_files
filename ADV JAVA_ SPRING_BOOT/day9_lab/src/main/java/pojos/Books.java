package pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {
	@Id // mandatory field level (alternatively can be added on the getter : property
	// level) ==> PK constraint

	// id int(5) primary key auto_increment,title varchar(20) unique ,author
	// varchar(20),category varchar(20),price double,available_stock int,pub_date
	// date);
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generating id' using constraint : auto_increment
	@Column(length = 5)
	private Integer id;
	@Column(length = 20, unique = true)
	private String title;
	@Column(length = 20)
	private String author;
	@Column(length = 20)
	private Category category;
	private double price;
	private int available_stock;
	private LocalDate pubDate;
	
	public Books(String title, String author, Category category, double price, int available_stock, LocalDate pubDate) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.available_stock = available_stock;
		this.pubDate = pubDate;
	}

	public Books() {
		System.out.println("In constructor of " + getClass());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailable_stock() {
		return available_stock;
	}

	public void setAvailable_stock(int available_stock) {
		this.available_stock = available_stock;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", price="
				+ price + ", available_stock=" + available_stock + ", pubDate=" + pubDate + "]";
	}
	


}
