package non_generic;

public class Tester {

	public static void main(String[] args) {
//		create holder class instance to hold the int.
		Holder h1 = new Holder(100);//100 = int --> INTEGER --> NUmber--> Object
		System.out.println("class loaded "+h1.getReference().getClass());
		int data = (Integer)h1.getReference();// programmer : downcasting | javac : autounboxing
//		create holder class instance to hold the String
		Holder h2 = new Holder("ADS");// javac :Stiring --> Object
		String s = (String)h2.getReference();// programmer : downcasting | javac : autounboxing
		h1 = h2;// h1 and h2 are reffering to holder class instance
		System.out.println(h1.getClass());
		System.out.println(h2.getClass());
		data = (Integer)h1.getReference();//class cast exc : String can't be cast into Integer
	}

}