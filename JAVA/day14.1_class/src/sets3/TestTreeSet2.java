package sets3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestTreeSet2 {
//print numbers in descending order
	public static void main(String[] args) {
		//TreeSet(Comparator<? super E> comparator), E : Integer
		TreeSet<Integer> ts=new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println("in compare");
				return o2.compareTo(o1);
			}
		});//
		
		System.out.println(ts);
		ts.addAll(Arrays.asList(120,34,-10,10,13,10,13,14,19,21,34));
		System.out.println(ts);
		
//		int[] data= {120,34,-10,10,13,10,13,14,19,21,34};
//		for(int i : data)
//			System.out.println("Added "+lhs.add(i));//TreeSet invokes : Integer's compareTo
//		System.out.println(lhs);//no duplicates, 
//		sorted ascending order	
		 

	}

}
