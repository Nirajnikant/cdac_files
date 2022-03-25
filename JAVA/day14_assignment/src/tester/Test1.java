package tester;

import java.util.HashSet;
import java.util.Scanner;

import com.app.books.Books;

import static utils.BooksValidationRules.validateBooks;


public class Test1 {

//	@SuppressWarnings("null")
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			HashSet<Books> books = new HashSet<Books>();
			boolean exit = false;
			while(!exit) {
				try {
				System.out.println("Options\n1. Add Books\n2. Show Books\n3. Exit");
				switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter details of book : title, price, publishDate, authorName, quantity, category");
						Books b = validateBooks(sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.nextInt(), sc.next(), books);
						books.add(b);
						break;
						
					case 2:
						System.out.println(books);
						break;
						
					case 3:
						exit = true;
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
	}

}
