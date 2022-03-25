package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class InsertEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter Emp details name | addr | salary | deptid | join_date(yr-mon-day)");
			System.out.println(dao.addEmpDetails(
					new Employee(sc.next(), sc.next(), sc.nextDouble(), sc.next(), Date.valueOf(sc.next()))));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
