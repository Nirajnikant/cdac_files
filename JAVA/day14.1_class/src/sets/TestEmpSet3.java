package sets;

import java.util.HashSet;

public class TestEmpSet3 {

	public static void main(String[] args) {
		//create empty HS<Emp> 
		//PK : emp id
		////BBBB AaBB AaAa BBAa
		HashSet<Emp> emps=new HashSet<>();
		Emp e1=new Emp("BBBB", "abc", 10000);
		Emp e2=new Emp("AaBB", "abc2", 20000);
		Emp e3=new Emp("AaAa", "abc3", 10000);
		Emp e4=new Emp("BBAa", "abc4", 10000);
		Emp e5=new Emp("BBAa", "abc2", 20000);
	
		System.out.println("Added "+emps.add(e1));//t , h 
		System.out.println("Added "+emps.add(e2));//t , h , eq : 1
		System.out.println("Added "+emps.add(e3));//t , h , eq : 2
		System.out.println("Added "+emps.add(e4));//t , h , eq 3
		System.out.println("Added "+emps.add(e5));//f , h eq 3
		
//		same hashcode then only it is going to call equals method :
//		in this case the hashcode were same therefore it has to call equals method 
//		multiple times thereby factor O(n) degrading the performance in edge case
		
//		in practical case the hashing based algorithm is detecting duplicates as well as giving constant time performance
		
		
		System.out.println(emps);//[...]
		System.out.println("size "+emps.size());

		
		//Contract : Mandatory : Equal objects MUST produce SAME hashcode
		

	}

}
