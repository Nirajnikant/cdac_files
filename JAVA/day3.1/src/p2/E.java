package p2;
import p1.A;
class E {
	E() {
		A ref = new A();
		System.out.println("C's state"+ref.i+" "+ref.j+" "+ref.k+" "+ref.l);
	}
}