package test_inhertance;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class Test3 {

	public static void main(String[] args) {
		Person p = new Student("a1", "b1", 2020, "pg-dac",80 ,123456);//upcasting
		System.out.println(p); //run time polymorphism : JVM toString : Student
//		p.study();  // study() doesn't exist in Person class
		((Student)p).study();//downcasting
		p = new Faculty("a2", "b2", 10, "java c#sharp react");//up casting
		System.out.println(p); //o/p : run time polymorphism :JVM toString : Faculty
//		((Student)p).study(); // no javac err. ilegal casting : run time err : java.lang.ClassCastExc.:
							// Faculty cannot be cast to class inheritance
		
		//add instanceof checking, before explicit down casting
		if(p instanceof Student) { //removes classcastexception by first checking and then 
			((Student)p).study();
		}
		else {
			System.out.println("INVALID TYPE!!!!!!!!!");
		}
	}
//	Object o = null;
//	o.getClass(); 
}