/*
Create another class : TestBox --for  UI.
Add psvmain(..){...}
Use scanner --to accept box dims from user, create box instance.
display its details & volume.
*/
package com.tester;
import com.cdac.core.*;
import java.util.Scanner;
class TestBox
{//USES-A relationship
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Box dims : w d h");
		Box b1;//ref type var : class type of the ref. ,local var :  mem allocated on stack : 4/8/16 bytes as per JVM's spec., no objects of type Box created so far
	//	System.out.println(b1);//javac err
	   b1=new Box(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
	   //print the address : hashCode 
	   System.out.println("b1's hashCode"+b1.hashCode());
	   //display dims n volume
	   System.out.println(b1.getBoxDetails());
	   System.out.println(b1.getComputedVolume());
	 	sc.close();
	}
}