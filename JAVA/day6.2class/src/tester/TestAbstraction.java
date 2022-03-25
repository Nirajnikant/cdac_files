package tester;

import com.app.shapes.*;


public class TestAbstraction {

	public static void main(String[] args) {
		//create rectangle and circle instances, add their ref inthe array and display 
		//their details + area from single for-each
		BoundedShape[] shapes = {new Rectangle(10,20,20.5,4.6),new Circle(50,100,12.5)};
		//3 objects
//		BoundedShape s1 = new BoundedShape(3); cannot instatiate abstract classs
		
		for(BoundedShape s : shapes) {
			System.out.println(s);
			System.out.printf("Area : %.2f %n",s.area());
		}
	}
}