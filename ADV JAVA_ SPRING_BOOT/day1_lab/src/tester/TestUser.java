package tester;

import java.util.Scanner;

import dao.UserDaoImpl;

public class TestUser {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter Email ID and Password");
			System.out.println(dao.authenticateUser(sc.next(), sc.next()));
			System.out.println("Enter Email ID and Password and new password");
			System.out.println(dao.changePassword(sc.next(), sc.next(), sc.next()));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
