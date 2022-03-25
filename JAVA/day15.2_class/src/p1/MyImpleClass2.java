package p1;

public class MyImpleClass2 implements Formula{

	@Override
	public double calculate(double a) {
		System.out.println("implimenting abstract method again");
		return a+a;
	}
	//Can imple class override inherited default method imple ? yes

	@Override
	public double sqrt(double a, double b) {
		// TODO Auto-generated method stub
//		return Formula.super.sqrt(a, b);
		System.out.println("overriding a default method");
		return Math.sqrt(a-b);
	}
	
	
}
