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

public class StudentAdmission {

	public static void main(String[] args) {
		try (Scanner sc= new Scanner(System.in);SessionFactory sf= getFactory()) {
			StudentDaoImpl student = new StudentDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter coure name");
			String courseTitle = sc.next();
			System.out.println("Enter Student Details : name , email");
			System.out.println(student.admitNewStudent(courseTitle, new Student(sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
