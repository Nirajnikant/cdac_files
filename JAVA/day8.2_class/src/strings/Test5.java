package strings;

public class Test5 {

	public static void main(String[] args) {
//		Testing String class APIs
		String s = "strings hello, testing strings here";
		System.out.println(s.charAt(0)+" "+s.charAt(s.length()-1));
		System.out.println("Anish".compareTo("Ashish"));//<0
		System.out.println("Atish".compareTo("Ashish"));//>0
		System.out.println(s.contains("strings"));//t  :searching
		System.out.println(s.indexOf("strings"));//0
		System.out.println(s.indexOf("strings",1));//23
		System.out.println(s.lastIndexOf("strings"));//23
		System.out.println(s.matches(".*[t]*"));//regex matching
	}

}
