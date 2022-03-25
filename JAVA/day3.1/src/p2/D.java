package p1;
import p1.A;
class D extends A{
	//private int i;
	//int j;
	//protected int k;
	//public int l;
	D() {
		//super();//javac adds it implicitly.
		System.out.println("D's state"+i+" "+j+" "+k+" "+l);
	}
}