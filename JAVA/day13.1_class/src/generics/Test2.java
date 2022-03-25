package generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		// create fixed size list of doubles : print it
		// shuffle it and print it
		List<Double> l1= Arrays.asList(1.0,4.5,6.7,3.456,6.89);
		System.out.println(l1);
		Collections.shuffle(l1);
		System.out.println("shuffled list "+ l1);
		//can you use shuffle for shuffling of string :: YES
//		public static void shuffle (List<?> list)
//		can you rewrite above using type paramater ? YES
//		public static <T> shuffle(List<T> list)
		//display contents of the linkedlist in reverse order : of strings : one two three
		LinkedList<String> l2 = new LinkedList<>(Arrays.asList("one","two","three","four"));
		Collections.reverse(l2);
		System.out.println(l2);
	}

}
