package test_inheritance;

import inheritance.Faculty;
import inheritance.Student;

public class Test1 {

	public static void main(String[] args) {
		// create student instance
		
		Student s1 = new Student("a1", "b1", 2020, "pg-dac", 80, 12456);
		//display student details
		System.out.println(s1.toString());
		
		// create faculty instance
		Faculty f1 = new Faculty("a2", "b2", 10, "java c#sharp react");
		//display faculty details
		System.out.println(f1.toString());
	}
}