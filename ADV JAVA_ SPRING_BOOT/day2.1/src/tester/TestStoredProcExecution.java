package tester;

import java.util.Scanner;

import dao.BankAccountDaoImpl;
import pojos.BankAccount;

public class TestStoredProcExecution {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			//create account dao instance
			BankAccountDaoImpl dao = new BankAccountDaoImpl();
			System.out.println("Enter src and destination account ids and amount ");
			System.out.println(dao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
