package strings;

public class Test4 {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = new String(s1);
		String s3 = "hello";
		String s4 = "Hello";
		System.out.println(s1 == s2);//false
		System.out.println(s1.equals(s2));//true
		System.out.println(s1 == s3);//t
		System.out.println(s1.equals(s3));//true
		System.out.println(s1 == s4);//f
		System.out.println(s1.equals(s4));//false
		System.out.println(s1.equalsIgnoreCase(s4));//true
	}

}
