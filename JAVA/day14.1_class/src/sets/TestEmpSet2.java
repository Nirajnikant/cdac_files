package sets;

import java.util.HashSet;

public class TestEmpSet2 {

	public static void main(String[] args) {
		// create empty HS<Emp>
		// Primary key : empId
		HashSet<Emp> emps = new HashSet<Emp>();
		Emp e1 = new Emp("rnd-001","abc",10000);
		Emp e2 = new Emp("rnd-002","abc2",20000);
		Emp e3 = new Emp("rnd-001","abc",10000);
		Emp e4 = new Emp("rnd-009","ab4",10000);
		Emp e5 = new Emp("rnd-006","abc2",20000);
		Emp e6 = new Emp("rnd-005","abc7",10000);
		System.out.println("Added "+ emps.add(e1));// t, hashCode	
		System.out.println("Added "+ emps.add(e2));// t, hashcode, equals : 1 times
		System.out.println("Added "+ emps.add(e3));// f, hashCode, equals : 1 times
		
		System.out.println("Added "+ emps.add(e4));// t, hashcode, equals : 2 times
		System.out.println("Added "+ emps.add(e5));// t, hashcode, equals : 3 times
		System.out.println("Added "+ emps.add(e6));// t. hashCode, equals : 4 times
		System.out.println(emps);//[...]
		System.out.println("size "+ emps.size());//5
//		System.out.println(e1.equals(e3));// t
//		System.out.println(e1.hashCode()+" "+e3.hashCode());//same values or different);
		
		//COntract : Mandatory : Equal objects MUST produce SAME hashcode

	}

}
