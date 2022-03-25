package p2;

public class C implements A, B{

	@Override
	public double calc(double a, double b) {
		return a+b;
	}
//	in case of duplicate method implementation : javac FORCES overriding
//	of the inherited default method

	@Override
	public void show() {
		System.out.println("Overriding duplicate def method");
		A.super.show();
		B.super.show();
	}
	

}
