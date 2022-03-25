package tester;

import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static java.time.LocalDate.parse;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try (Scanner sc= new Scanner(System.in);SessionFactory sf= getFactory()) {
			StudentDaoImpl student = new StudentDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter coure name and student Id");
			String courseTitle = sc.next();
			System.out.println(student.cancelAdmission(courseTitle, sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}