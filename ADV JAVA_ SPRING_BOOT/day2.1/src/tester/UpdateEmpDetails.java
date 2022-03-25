package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class UpdateEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter Emp details empdid, new dept, salary increment");
			System.out.println(dao.updateEmpDetails(sc.nextInt(), sc.next(), sc.nextDouble()));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
