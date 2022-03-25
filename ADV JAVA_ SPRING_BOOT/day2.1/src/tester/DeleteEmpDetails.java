package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class DeleteEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter Emp id");
			System.out.println(dao.deleteEMpDetails(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
