package strings;

public class Test3 {

	public static void main(String[] args) {
//		 == vs equals
		Object s1 = new String("abcdefgh");//up casting
		Object s2 = new String("abcdefgh");//up casting
		System.out.println(s1 == s2);// false : reference equality
		System.out.println(s1.equals(s2));//JVM resolves by type of object , yupe of object is string
//		so it goes by string class equals and checks content
//		replace reference equality to content equality
//		true
//		String s3 = s2.toUpperCase();//err : javac goes by type of ref s2 ref is object
		String s3 = ((String)s2).toUpperCase();//down casting 
		System.out.println(s2==s3);//f
		System.out.println(s2.equals(s3));//f
//		System.out.println(s2.equalsIgnoreCase(s3));//err : javac goes by type of ref s2 ref is object
		System.out.println(((String)s2).equalsIgnoreCase(s3));// down casting
//		object class equals() based on reference equality
//		Object class equals() based on content equality : overrides object equals 
	}

}
