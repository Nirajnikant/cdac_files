package tester;

import dao.UserDaoIMpl;
import pojo.Role;

import java.util.Scanner;
import org.hibernate.SessionFactory;
import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

public class GetSelectedUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);SessionFactory sf = getFactory()) {
			// create dao instance
			UserDaoIMpl userDao = new UserDaoIMpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter begin date, end date, role");
			System.out.println("Selected users :");
			userDao.getSelectedUsers(parse(sc.next()), parse(sc.next()), Role.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		} // sf.close()=> closing of connection pool
	}
}