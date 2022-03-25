package test_static;

import java.util.Scanner;

//to tell javac : accessing DIRECTLY static member : out from System class
import static java.lang.System.out;
//to tell javac : accessing DIRECTLY static member : PI, sqrt from Math class
import static java.lang.Math.*;
//to tell javac : accessing DIRECTLY static member : in from System class
import static java.lang.System.in;

//import static java.lang.*  --wrong syntax after lang class name should be given

public class Test2 {
static double pi2 = PI;
	public static void main(String[] args) {
//		System.out.println("Testing static keyword");
//		System.out.println("Printing sqrt of 10 "+ Math.sqrt(10));
////				^static									^static		
//		System.out.println("PI "+Math.PI);
////									   ^static
		
		
		//can use access static members DIRECTLY : w/o using className.memberName : YES
		out.println("Testing static keyword");
		out.println("Printing sqrt of 10 "+ sqrt(10));	
		out.println("PI "+PI);
		Scanner sc = new Scanner(in);
//		static double pi = PI;   //compiler error :: static member cannot be defined within a method local

		sc.close();
	}

}
