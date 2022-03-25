package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoIMpl;
import pojo.Role;
import pojo.User;

public class RegisterUserWithGetCurrentSession {

	public static void main(String[] args) {
		try ( Scanner sc = new Scanner(System.in); SessionFactory sf= getFactory()) {
			//create dao instance
			UserDaoIMpl userDao = new UserDaoIMpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter your details : name, email, password, confirmPassword, userRole, regAmount,\r\n"
					+ " regDate");
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println(userDao.registerUserWithCurrentSession(user));
		}// sf.close()=> closing of connection pool
	}

}
