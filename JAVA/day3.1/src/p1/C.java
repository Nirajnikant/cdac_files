package p1;
class C {
	C() {
		A ref = new A();
		System.out.println("C's state"+ref.i+" "+ref.j+" "+ref.k+" "+ref.l);
	}
}