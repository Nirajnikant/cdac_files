package p2;

public interface A {
	//implicit keyword added by javac : public, abstract
	double calc(double a, double b);
	//default method implementation
	//implicit keyword added by javac : public
	default void show() {
		System.out.println("1");
	}
}
