package utils;

import java.util.List;

public class GenericUtils {
	public static void printList(List<?> list) {
		for(Object e : list)
			System.out.println(e);
			
	}
}