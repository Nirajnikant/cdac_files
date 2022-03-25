package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.ProjectDaoImpl;

public class DisplayStudentDeatilsFromProjectTitle {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl dao = new ProjectDaoImpl();
			System.out.println("Hibernate up n running ....." + sf);
			System.out.println("Enter project title to get names of students");
			dao.getCourseStudentDetails(sc.next()).forEach(s -> System.out.println(s.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
