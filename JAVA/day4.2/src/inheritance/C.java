package inheritance;

 class A{
	A() {
		super();//javac adds it implicitly
		System.out.println("In A's ctor");
	}
}

class B extends A {
	B() {
		super();//javac adds it implicitly => invoking immediate super cls's def ctor
		System.out.println("In B's ctor");
	}
}

public class C extends B {
	public C() {
		super();//javac adds it implicitly
		System.out.println("In C's ctor");
	}
}
