package strings;

public class Test2 {

	public static void main(String[] args) {
//		 == vs equals
		String s1 = new String("abcdefgh");
		String s2 = new String("abcdefgh");
		System.out.println(s1 == s2);// false : reference equality
		System.out.println(s1.equals(s2));//String class has overridden Object class's equals method , tp 
//		replace reference equality to content equality
//		true
		String s3 = s2.toUpperCase();
		System.out.println(s2==s3);//f
		System.out.println(s2.equals(s3));//f
		System.out.println(s2.equalsIgnoreCase(s3));//t
		
//		object class equals() based on reference equality
//		string class equals() based on content equality : overrides object equals 
	}

}
