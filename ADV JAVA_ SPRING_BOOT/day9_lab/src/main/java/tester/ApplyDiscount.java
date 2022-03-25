package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import static java.time.LocalDate.parse;
import dao.BookDaoImpl;

public class ApplyDiscount {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);SessionFactory sf = getFactory()) {
			// create dao instance
			BookDaoImpl bookDao = new BookDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter date and discount");
			System.out.println(bookDao.discountApplied(parse(sc.next()), sc.nextDouble()));
		} // sf.close()=> closing of connection pool
	}

}
