package utils;

import java.time.LocalDate;
import java.util.HashSet;

import com.app.books.Books;
import com.app.books.Category;

import custom_exceptions.BookHandlingExceptions;

public class BooksValidationRules {

	private static void duplicateValidate(HashSet<Books> book, String title) throws BookHandlingExceptions {
		Books newBook = new Books(title);
		if(book!=null) {
		for (Books b : book) {
			if (b != null) {
				if (b.equals(newBook))
					throw new BookHandlingExceptions("Duplicate Book");
			}
		}
		}
	}
	
	public static Category validateCategory(String category) {
		return Category.valueOf(category.toUpperCase());// if user supplies unknown category : JVM will throw
//		java.lang.IllegalArgumentException : uncheckeed exception
	}

	public static Books validateBooks(String title, double price, String publishDate, String authorName,
			int quantity, String category, HashSet<Books> books) throws BookHandlingExceptions {
		duplicateValidate(books, title);
		Category type1 = validateCategory(category);
		LocalDate d = LocalDate.parse(publishDate);
		return new Books(title, price, d, authorName, quantity, type1);
	}
}
