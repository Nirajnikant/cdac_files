package dates;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		Date d1 = new Date();//d1  referring to date class instance => current date
		System.out.println(d1);
		Date d2 = new Date(5000);//d2  referring to date class instance => epoch(1ssst jan 1970 + 5sec
		System.out.println(d2);
		System.out.println(d2.compareTo(d2));//+ive number api returns 1
		System.out.println(d1.before(d2));//false : if d1 is before d2
		System.out.println(d1.after(d2));//true : is d1 after d2
		System.out.println(d1.equals(d2));//false : contnent inequality
	}

}
