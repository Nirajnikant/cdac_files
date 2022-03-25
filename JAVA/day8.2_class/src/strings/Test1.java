package strings;

public class Test1 {

	public static void main(String[] args) {
		//immutability of strings
		String s1 = new String("Hello");
		s1.concat("hi");
		System.out.println(s1);//o/p as hello because is string is immutable
		s1 += "12345";
		System.out.println(s1);
		System.out.println(s1.length());
		s1.toUpperCase();//s1 is immutable so s1 still points to earlier string but here it creates a new string 
//		where s1 is not pointing
		System.out.println(s1);//hellp12345
		System.out.println(s1.replace('l','p'));
	}
}