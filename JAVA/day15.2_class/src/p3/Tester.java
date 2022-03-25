package p3;

public class Tester {

	public static void main(String[] args) {
		Formula ref = new MyImpleClass();
		System.out.println(ref.calculate(100));
		Formula.print("dsa");
		MyImpleClass.print("hi");
	}

}
