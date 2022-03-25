package tester;

import java.util.Scanner;
import dao.BankAccountDaoImpl;

public class Test {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			BankAccountDaoImpl dao = new BankAccountDaoImpl();
			System.out.println("Enter src and destination account ids and amount ");
			System.out.println(dao.update_account(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}