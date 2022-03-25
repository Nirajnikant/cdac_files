package sets3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> lhs=new TreeSet<>();//default constructor => natural ordering (ascending order)
		int[] data= {120,34,-10,10,13,10,13,14,19,21,34};
		for(int i : data)
			System.out.println("Added "+lhs.add(i));//TreeSet invokes : Integer's compareTo
		System.out.println(lhs);//no duplicates, 
//		sorted ascending order	
		 

	}

}
