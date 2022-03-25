package utils;

import java.util.List;

public class GenericUtils {
//	public static Integer findMax(List<Integer> numbers) {
//		Integer max = numbers.get(0);
//		for(int i=1;i<numbers.size();i++)
//			if(numbers.get(i).compareTo(max)>0)
//				max = numbers.get(i);
//		return max;
//	}
	
//	public static Number findMax(List<? extends Number & Comparable> numbers) {
//		Number max = numbers.get(0);
//		for(int i=1;i<numbers.size();i++)
//			if(numbers.get(i).compareTo(max)>0)
//				max = numbers.get(i);
//		return max;
//	}
//	<T extends Number & Comparable<T>> Any type T that extends from Number n imple Comparable
	public static <T extends Number & Comparable<T>> T findMax(List<T> numbers) {
		T max = numbers.get(0);
		for(int i=1;i<numbers.size();i++)
			if(numbers.get(i).compareTo(max)>0)
				max = numbers.get(i);
		return max;
	}
	
	public static <T extends Comparable<T>> T findAnyMax(List<T> numbers) {
		T max = numbers.get(0);
		for(int i=1;i<numbers.size();i++)
			if(numbers.get(i).compareTo(max)>0)
				max = numbers.get(i);
		return max;
	}
	
	public static <T> void copy(List<? extends T>src ,List<? super T> dest)
	{
		for(T t : src)
			dest.add(t);
		
	}
}
