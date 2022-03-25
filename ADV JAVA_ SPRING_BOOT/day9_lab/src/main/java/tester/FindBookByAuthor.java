package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.BookDaoImpl;
import pojos.Books;
import pojos.Category;

public class FindBookByAuthor {

	public static void main(String[] args) {
		try ( Scanner sc = new Scanner(System.in); SessionFactory sf= getFactory()) {
			//create dao instance
			BookDaoImpl bookDao = new BookDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter book author, date after");
			bookDao.findByAuthor(sc.next(), parse(sc.next()));
		}// sf.close()=> closing of connection pool
	}

}
