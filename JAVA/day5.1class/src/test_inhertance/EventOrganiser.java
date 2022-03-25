package test_inhertance;

import java.util.Scanner;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class EventOrganiser {

	public static void main(String[] args) {
		//sc : stding
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter event capacity");
		
		//create D.S. to hold different type of participant details
		Person[] participants = new Person[sc.nextInt()];
		//1 array holder obj : that can hold Person type refs.
		//which can later refer to either Student or Faculty type of the object : thanks to upcasting!!
		boolean exit = false;
		int counter = 0;
		while(!exit) {
			System.out.println("Options 1. Register 2. Faculty Registration 3. Display info 4. Invoke specific functionality 100.Exit");
			
			switch (sc.nextInt()) {
			case 1: //Student reg
				if(counter < participants.length) {
					System.out.println("Enter Student Details: fn, ln, yr, courseName, marks, fees");
					participants[counter++] = new Student(sc.next(),sc.next(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt());//upcasting
				}
				else
					System.out.println("Event Full!!!");
				break;
			case 2://Faculty reg
				if(counter < participants.length) {
					System.out.println("Enter Faculty Details: fn, ln, Exyr, Sme");
					participants[counter++] = new Faculty(sc.next(),sc.next(), sc.nextInt(), sc.next());//upcasting
				}
				else
					System.out.println("Event Full!!!");
				break;
			case 3://Display info :for-each
				for(Person p : participants)//p = participants[0], participants[1]....participants[participants.length]
					System.out.println(p);//{s1,s2,f1,s3,s4,null,null.....}
					// runtime polymorphism----
					// when super class ref is refering to subclass obj and it is the decision taken in runtime
				break;
			case 4://Invoke specific functionality
				System.out.println("Enter Seat no.");
				int index = sc.nextInt()-1;
				if(index>=0 && index<counter) {
					Person p1 = participants[index];
					if(p1 instanceof Student) 
						((Student)p1).study();
					else if(p1 instanceof Faculty) 
						((Faculty)p1).toString();
				}
				else 
					System.out.println("Invalid Seat no.");
				break;
			case 100:
				exit = true;
				break;
			}
		}
		sc.close();
	}
}
