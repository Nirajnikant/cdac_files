package utils;

import static java.time.LocalDate.parse;

import java.util.HashMap;

import com.app.books.Books;
import com.app.books.Category;
import static com.app.books.Category.*;

public class CollectionUtils {
//	title, price, publishDate, authorName, quantity, category
//	System.out.println(map.put("Gaban",new Books("Gaban", 150, 1935-01-23, "Premchand", 15, Category.FICTION));
	public static HashMap<String, Books> populateMap() {
		HashMap<String, Books> map = new HashMap<String, Books>();
		System.out.println(map.put("Gaban", new Books("Gaban", 150, parse("1935-01-23"), "Premchand", 15, FICTION)));
		System.out.println(map.put("Harry Potter", new Books("Harry Potter", 250, parse("1981-03-13"), "abced", 19, FICTION)));
		System.out.println(map.put("Dongri to Dubai", new Books("Dongri to Dubai", 200, parse("2010-11-21"), "Hussain Zaidy", 25, BIOGRAPHY)));
		System.out.println(map.put("A Train to Pakistan", new Books("A train to Pakistan", 350, parse("1996-08-16"), "SOme One", 5, NONFICTION)));
		System.out.println(map.put("3 idiots", new Books("3 idiots", 150, parse("2011-12-13"), "Chetan Bhagat", 12, AUTOBIOGRAPHY)));
		return map;
	}
}
