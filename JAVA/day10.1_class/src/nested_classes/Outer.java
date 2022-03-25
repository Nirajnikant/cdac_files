package nested_classes;

public class Outer {
//	can outer class contain static as well as non static members? : YES
	private int i;
	private static int j;
	static {
		j=10;
	}
	public Outer(int i) {
		this.i = i;
	}
//	can outer class contain static as well as non static members? YES
	public void show() {
		System.out.println("from outer's non-static method"+i+j);
		//can outer class(non static method) access inner's data members DIRECTLY? (w/o instantiation) : NO
		//simply create inner class instance and access it!
//		System.out.println(l);//outer class cannot access inner class members directly
		Inner in = new Inner(121345);
		System.out.println("Accessing inner's members"+in.l);
		in.showInnner();
	}
	public static void print() {
		System.out.println("form outer's staic method"+j);//i : inaccessible directly;
		//how to access inner classes members?
//		Inner in = new Inner(12345);
		Outer o = new Outer(11);
//		how to create inner class ref? : Outer.Inner
		Outer.Inner in = o.new Inner(12);
		in.showInnner();
//		combining last 2 lines
		Outer.Inner in2 = new Outer(34).new Inner(78);
		in2.showInnner();
	}
//	nested class : non static nested class : inner class
	public class Inner {
//	can inner class(= non static nested class) contain static data members? : NO (static constants are allowed)
//		because static gets initialized at class loading time and compiler does not want to give the direct access to the inner class
		private static final int k = 20;
//		static {
//			k=10;  // cannot define static initializer block in a inner type
//		}
		
//		can inner class(= non static nested class) contain non-static data members? : YES
		private int l;

		public Inner(int l) {
			super();
			this.l = l;
		}
		//can inner class contains static method? : NO 
//		public static void test1() {
//			
//		}
//		can you add non static methods in inner class? : Yes
		public void showInnner() {
			//Inner class can directly access outer class's members : since every inner class is implicitly
			//associated with Outer class instance.
			System.out.println("from inner's non static method "+i+" "+j+" "+k+" "+l);
		}



	}
}