package tester;

import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;

import dao.AddressDaoImpl;
import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Address;
import pojos.Course;
import pojos.Student;

import static java.time.LocalDate.parse;

public class AssignStudentAddress {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDaoImpl student = new AddressDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter student id, to link address details");
			int studentId = sc.nextInt();
			System.out.println("Enter Address Details : city, state, country, zipCode");
			System.out.println(
					student.assignAddressDetails(studentId, new Address(sc.next(), sc.next(), sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
