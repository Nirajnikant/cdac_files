package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoIMpl;
import pojo.Role;

public class ChangePassword {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);SessionFactory sf = getFactory()) {
			// create dao instance
			UserDaoIMpl userDao = new UserDaoIMpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter email old ped and new pwds");
			System.out.println(userDao.changePassword(sc.next(), sc.next(), sc.next()));
		} // sf.close()=> closing of connection pool
	}
}