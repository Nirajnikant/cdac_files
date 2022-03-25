package p2;

public interface B {
	//default method implementation
	//implicit keyword added by javac : public
	default void show() {
		System.out.println("2");
	}
}
