package tester;

import static utils.BooksValidationRules.validateBooks;
import static com.app.books.Category.valueOf;
import static utils.CollectionUtils.populateMap;
import static java.time.LocalDate.parse;
import java.util.HashMap;
import java.util.Scanner;

import com.app.books.Books;

import custom_exceptions.BookHandlingExceptions;

public class Test1 {

//	@SuppressWarnings("null")
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HashMap<String, Books> books = populateMap();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println(
							"Options\n1. Add Books\n2. Show Books\n3. Issue Single Book\n4. Return book\n5. Remove title\n10. Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter title of the book : ");
						String name = sc.next();
						if (books.containsKey(name)) {
							Books book = books.get(name);
							System.out.println("Enter New quantity");
							book.setQuantity(sc.nextInt());
						} else {
							System.out.println(
									"Enter details of book : price, publishDate, authorName, quantity, category");
							books.put(name, new Books(name, sc.nextDouble(), parse(sc.next()), sc.next(), sc.nextInt(),
									valueOf(sc.next().toUpperCase())));
							System.out.println("Book added");
						}
						break;

					case 2:
						System.out.println("All books details");
						for (Books b : books.values())
							System.out.println(b);
						break;

					case 3:
						// 2.3 Issue out a single copy of the book.
						// i/p book title
						// If the book is found , update the quantity suitably.
						// Otherwise , raise suitable exception
						System.out.println("Enter Book title");
						Books book = books.get(sc.next());
						if (book == null)
							throw new BookHandlingExceptions("Book not found");
						else {
							book.setQuantity(book.getQuantity() - 1);
						}
						break;

					case 4:
//						2.4 Return a book
//						i/p book title
//						If the book is found , update the quantity suitably.
//						Otherwise , raise suitable exception
						System.out.println("Enter Book title");
						Books book1 = books.get(sc.next());
						if (book1 == null)
							throw new BookHandlingExceptions("Book not found");
						else {
							book1.setQuantity(book1.getQuantity() + 1);
						}
						break;

					case 5:
//						Remove book
//						i/p book title
//						If the book is found , update the quantity suitably.
//						Otherwise , raise suitable exception
						System.out.println("Enter Book title");
						Books b1 = books.remove(sc.next());
						if(b1 == null)
							throw new BookHandlingExceptions("Book not Found");
						System.out.println(b1 + " Book removed");
						break;

					case 10:
						exit = true;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				sc.nextLine();
			}
		}

	}

}
