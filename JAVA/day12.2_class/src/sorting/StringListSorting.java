package sorting;

import java.util.ArrayList;
import java.util.Collections;

import utils.CollectionUtils;

public class StringListSorting {

	public static void main(String[] args) {
		String[] names = {"Rutuj","Anish", "Riya", "Ankit","Mihir","Rama","Tanvee"};
		//create Al<String> populated with above names.
		ArrayList<String> list = new ArrayList<String>();
		for(String s : names)
			list.add(s);//orderly added names(array of string) to list(AL of string)
		System.out.println("org list "+list);
		//java.util.Collections : class, helper class, static methods -- sorting
		//Method of Collections class : public static void sort(List<T> list)
		Collections.sort(list);
		System.out.println("SORTED LIST : "+list);
	}

}
