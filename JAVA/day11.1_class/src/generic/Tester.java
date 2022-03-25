package generic;

public class Tester {

	public static void main(String[] args) {
//		create holder class instance to hold the int.
		Holder<Integer> h1 = new Holder<Integer>(100);//Implicit conversion done by javac
		//int --> Integre : autoboxing  :: it goes only till Integer rather than going to Object
		
//		Diamond operator => javac can automatically infer generic type of the RHS from the LHS 
		Holder<Integer> h2 = new Holder<>(100);
		int data = h1.getReference();//RHS : Integer --> int : javac auto unboxing

//		create holder class instance to hold the String
		Holder<String> h3 = new Holder<>("Generics");//javac implicit conversion : NONE
		String s = h3.getReference();// no explicit down casting
		
//		h1=h3;//catching type mismatch errors @ compile time -- so as to avoid run time err : ClassCastExc.
			  // type of h1-- holder holding an Integer
			  // type of h3-- holder holding a String 
		
	}

}