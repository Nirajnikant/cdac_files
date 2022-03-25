package test_inhertance;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class test2 {

	public static void main(String[] args) {
		//super class ref, super class instance, sub class ref, sub class obj(person, Student, Faculty)
		Person p;//p: super class reference
		p = new Person("a1", "b1"); //lhs : super class ref --> super class instance, : Direct Referencing
		p = new Student("a1", "b1", 2020, "pg-dac",80 ,123456); //LHS : super class ref ---> subclass instance ///indirect refrencing
		//why no javac error : extends :: Student IS-A Person ---upcasting : implicitly done by compiler
		Object o;// o: universal super class ref
//		System.out.println(o); obejct o is not insisilized ||| javc err untill oa obejct is initilized
		o = p;//no javac err : compiler goes by type of ref for resolving any assignment compiler goes by type of ref
				// Person IS-A Object
		//Emp <-- Mgr <---- HRMgr
		//Emp e = new HRMgr(...);//upcasting
		
		System.out.println(p);//p.toString : javac checks by type of the ref : p : Person, what will be o/p::
				//student's toString : this decision of invoking toString method, on which type of the instance 
				//is taken dynamically(i.e. @run time)=> runtime polymorphism
		
		//jvm --type of ref
		//jre --type of obj
		
		System.out.println(o);//object --> p-->student instance ant runtiem :runtimepolymorphism 
		//	o/p w.r.t. student
		
		 o = new Faculty("a2", "b2", 10, "java c#sharp react"); //up casting
		 System.out.println(o);//o/p : faculty's complete details : method bindig : runtime = > run time polymorphism
		 
	}
}
