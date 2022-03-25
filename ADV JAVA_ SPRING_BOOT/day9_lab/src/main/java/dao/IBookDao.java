package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Books;

public interface IBookDao {
	String addBooks(Books book);
	Books findById(int id);
	List<Books> findByAuthor(String author, LocalDate dateAfter);
	String discountApplied(LocalDate date, double discount);
}
