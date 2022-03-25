package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class TestGenericMethod {

	public static void main(String[] args) {
		// create fixed sized integer list :10, 20, 30 40 50 60 
		//API : java.util.Arrays : public static <T> List<T> asList(T... args
		List<Integer> list = Arrays.asList(10,20,30,40,50,60);
//		list.add(70);//UnsupportedOperationException
//		list.remove(0);//UnsupportedOperationException
		list.set(0, 999);
		System.out.println(list);
//		create fixed size double list :10, 20, 30 40 50 60
		List<Double> list2 = Arrays.asList(10.0, 20.0, 30.0 ,40.0, 50.0, 60.0);
		System.out.println(list2);
		Integer[] data = {1,2,3,4,5};//autoboxing
		list = Arrays.asList(data);
		System.out.println("implementation class" + list.getClass());
		//create growable list of integers : 10, 20 , 30 , 40 , 50, 60 in single java statement
		//LinkedList<E> (Collection<E> collection)
		LinkedList<Integer> list3 = new LinkedList<>(Arrays.asList(10,20,30,40,50,60));
		list3.addFirst(100);
		System.out.println(list3);//[100, 10,20,30,40,50,60]
	}
}