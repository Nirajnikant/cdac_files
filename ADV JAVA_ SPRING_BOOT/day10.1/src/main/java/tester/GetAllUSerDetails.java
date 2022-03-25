package tester;

import pojo.Role;
import pojo.User;
import dao.UserDaoIMpl;
import java.time.LocalDate;
import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

public class GetAllUSerDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			// create dao instance
			UserDaoIMpl userDao = new UserDaoIMpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("All users :");
			userDao.getAllUsers().forEach(System.out::println);
		} // sf.close()=> closing of connection pool
	}
}