package tester;

import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.CourseDaoImpl;
import pojos.Course;

import static java.time.LocalDate.parse;

public class LaunchNewCourse {

	public static void main(String[] args) {
		try (Scanner sc= new Scanner(System.in);SessionFactory sf= getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter new Course details : title, startDate, endDate, fees, capacity");
			System.out.println(courseDao.launchNewCourse(new Course(sc.next(), parse(sc.next()),parse(sc.next()),sc.nextDouble(), sc.nextInt())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
