package inheritance;

 class A {
	A() {
		super(); //compiler adds it implicitly
		System.out.println("In A's constructor");
	}
}

class B extends A {
	B() {
		super(); //compiler adds it implicitly => invoking immediate super classes default constructor
		System.out.println("In B's constructor");
	}
}

public class C extends B {
	public C() {
		super(); //compiler adds it implicitly:::extends adds super implicitly
		System.out.println("In C's constructor");
	}
}