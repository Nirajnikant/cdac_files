package tester;

import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;

import dao.CourseDaoImpl;
import pojos.Course;

import static java.time.LocalDate.parse;

public class GetCourseDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter course name");
			Course course = courseDao.getCourseDetails(sc.next());
			System.out.println("Course details");
			System.out.println(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}