package p3;

public class MyImpleClass implements Formula{
//must implement abstract methods
	
	@Override
	public double calculate(double a) {
		System.out.println("implimenting abstract method");
		return a*a;
	}
	//Imple. class can access inherited default method : YES
	// can it override public default method : Yes
	//Can you override interfaces static method : No, can be re-declared
//	@Override
	static void print(String message) {
		System.out.println("Printing a messsage "+message+" from class's static method");
		Formula.print("bye");//how to refer to i/f static method? i/f Name.method
	}
}
