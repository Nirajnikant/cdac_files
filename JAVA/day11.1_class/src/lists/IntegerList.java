package lists;

import java.util.ArrayList;
import java.util.Scanner;

public class IntegerList {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			// create some sample data : int []
			int[] data = {10,20,1,23,56,-10,10,20,33,567,10};
			// create empty ArrayLit to store Integer type of refs, with default initial capacity of 10
			ArrayList<Integer> list = new ArrayList<Integer>();//size = 0, capacity= 10
			//populate ArrayList from array data.
			for(int i: data)//i= data[0]....i=data[data.length-1]
				list.add(i);//i=int --> Integer
			//display elements from the ArrayList
			System.out.println("AL via toString "+list);//AL's toString;
			
		
			//Can you attach for-loop to any List? YES : list is a index based collection
			System.out.println("AL using for loop");
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
			
			//Can you attach for-each to any List? YES
			System.out.println("AL using for-each loop");
			for(int i: list)//Integer --> int auto Unboxing
				System.out.println(i);
			
			//print "Exists" or "Doesn't Exist" : if user supplied element is found 
			System.out.println("Enter a number to search");
			System.out.println(list.contains(sc.nextInt())?"Exists":"Does Not Exists");
			
			//display index of 1st occurrence  and last occurrence of user specified element
			System.out.println("Enter a number to find first and last ocurrence");
			int data1 = sc.nextInt();
			System.out.println("First "+list.indexOf(data1));
			System.out.println("Last "+list.lastIndexOf(data1));
			
			//remove
			System.out.println("Enter index to be removed");
			list.remove(sc.nextInt());//removes 1st occurrence
			System.out.println(list);
			
			//double all elements in the list, having values > 25
			for(int i=0;i<list.size();i++) {
				if(list.get(i)>25)
					list.set(i, list.get(i)*2);
			}
			System.out.println("EDITED");
			System.out.println("list1"+list);
			
			//create another AL having same elements as this list.: ArrayList (Collection<E> coll)
			ArrayList<Integer> list2 = new ArrayList<Integer>(list);//copy of ref  ::: creates 2 separate lists referencing to same integr object
			System.out.println("list2 "+ list2);
			
			list2.remove(0);
			System.out.println(list2);
			System.out.println(list);
		}
		
	}
	
}