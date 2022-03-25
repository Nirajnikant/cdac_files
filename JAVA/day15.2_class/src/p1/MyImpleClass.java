package p1;

public class MyImpleClass implements Formula{

	@Override
	public double calculate(double a) {
		System.out.println("implimenting abstract method");
		return a*a;
	}
	//Imple. class can access inherited default method
}
