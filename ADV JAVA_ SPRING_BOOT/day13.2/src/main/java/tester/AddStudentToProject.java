package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.ProjectDaoImpl;

public class AddStudentToProject {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			ProjectDaoImpl projectDao = new ProjectDaoImpl();
			System.out.println("Hiberbate up and running..." + sf);
			System.out.println("Enter Project Id and Student Id");
			System.out.println(projectDao.addStudentToProject(sc.nextInt(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
