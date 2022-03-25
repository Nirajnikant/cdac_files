package queue;

import java.util.Arrays;
import custom_exceptions.SListExceptions;
import custom_exceptions.StackException;

public class StackUsingQueueMain {

	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 4, 5};
//		System.out.println("Original array: " + Arrays.toString(arr));
		StackUsingQueue stackObj = new StackUsingQueue(6);
		try {
//			Reverse(arr, stackObj);
			 stackObj.Push(5);
			 stackObj.Display();
			 stackObj.Push(6);
			 stackObj.Display();
			 stackObj.Push(2);
			 stackObj.Display();
			 stackObj.Push(3);
			 stackObj.Display();
			 stackObj.Push(7);
			 stackObj.Display();
			 stackObj.Push(3);
			 stackObj.Display();
//			 System.out.println(stackObj.Pop());
//			 System.out.println(stackObj.Pop());
//			 System.out.println(stackObj.Pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("Reverse array: " + Arrays.toString(arr));

	}

}
