package tester;

import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import dao.CourseDaoImpl;
import pojos.Course;

import static java.time.LocalDate.parse;

public class GetCourseAndStudentDetails2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter course name");
			Course course = courseDao.getCourseStudentDetails(sc.next());
			System.out.println("Course details");
			System.out.println(course);
			System.out.println("Student details");
			course.getStudents().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}