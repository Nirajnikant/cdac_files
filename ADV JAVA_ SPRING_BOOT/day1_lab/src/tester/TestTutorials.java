package tester;

import java.util.Scanner;
import daoTutorials.TutorialDaoImpl;

public class TestTutorials {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			TutorialDaoImpl dao = new TutorialDaoImpl();
			dao.getAllTutorials().forEach(System.out::println);
			System.out.println("");
			System.out.println("Enter Name of the Tutorials");
			String name = sc.nextLine();
			System.out.println(dao.getTutorialDetail(name));
			System.out.println("Enter Tutorial Id");
			System.out.println(dao.updateVisits(sc.nextInt()));
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}