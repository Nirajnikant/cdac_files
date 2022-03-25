package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.ProjectDaoImpl;
import pojos.Project;
import static java.time.LocalDate.parse;

public class LaunchNewProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl projectDao = new ProjectDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter new Project details : title, technology, completionDate");
			System.out.println(projectDao.launchNewProject(new Project(sc.next(), sc.next(), parse(sc.next()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
