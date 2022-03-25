package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class TestLayeredApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create DAO instance
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter dept n date");
			dao.getSelectedEmpDetails(sc.next(), Date.valueOf(sc.next())).forEach(System.out::println);
			//destroy /shut down 
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}