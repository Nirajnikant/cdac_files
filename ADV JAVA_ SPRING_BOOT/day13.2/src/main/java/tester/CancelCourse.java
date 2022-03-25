package tester;

import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.CourseDaoImpl;
import pojos.Course;

import static java.time.LocalDate.parse;

public class CancelCourse {

	public static void main(String[] args) {
		try (Scanner sc= new Scanner(System.in);SessionFactory sf= getFactory()) {
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter course Id to cancel");
			System.out.println(courseDao.cancelCourse(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
