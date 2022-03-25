package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoIMpl;
import pojo.Role;
import pojo.User;

public class GetUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			UserDaoIMpl userDao = new UserDaoIMpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter UserId");
			System.out.println(userDao.findByUser(sc.nextInt()));
		} // sf.close()=> closing of connection pool
	}
}