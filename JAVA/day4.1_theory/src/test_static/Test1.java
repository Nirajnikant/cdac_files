package test_static;

public class Test1 {
	public static int i;  //-- only one copy is made
	private int j;	// created one per instance
	
	public static void main(String[] args) {
		System.out.println("printing "+i);	
		// static method can access other static members/method without instantiation 
		//because static members are available at class loading time
		
		show(); // static method can access other static members/method without instantiation
		//System.out.println(j);// Compile time error static method cannot access non static members
		//because instance variable are available after object creation
		//how tp access j? : --> first. create object 
		Test1 t1 = new Test1(); //object created
		System.out.println(t1.j);//non static j is accessed after object creation
//		print();
//		t1.show();// can be done but there is warning 
	}
	
	private static void show() {
		System.out.println("in show"+i);
		// static method can access other static members without instantiation
		//System.out.println(j);// Compile time error static method cannot access non static members
				//how tp access j? : with obj creation
	}
	
	private void print() {
		System.out.println("in show"+i);
		//non static methods can access other static members directly(w/o instantiation)
		
		//because static members are available at class loading time
		
		show(); //non-static members can access other static method
	}
}
