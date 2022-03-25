package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDaoImpl;
import pojos.Books;
import pojos.Category;
import static java.time.LocalDate.parse;


public class AddBook {

	public static void main(String[] args) {
		try ( Scanner sc = new Scanner(System.in); SessionFactory sf= getFactory()) {
			//create dao instance
			BookDaoImpl bookDao = new BookDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
//			String title, String author, Category category, double price, int available_stock, LocalDate pubDat
			System.out.println("Enter your details : title, author, category, price, available_stock, publich date");
			Books book = new Books(sc.next(), sc.next(), Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(), sc.nextInt(), parse(sc.next()));
			System.out.println(bookDao.addBooks(book));
		}// sf.close()=> closing of connection pool
		
	}

}
