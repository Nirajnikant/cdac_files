package SList;
import java.util.Arrays;

import custom_exceptions.*;

public class StackUsingListMain {
//	public static void Reverse(int[] elements, StackIntf stack) throws StackException {
//		for (int i = 0; i < elements.length; ++i) {
//				stack.Push(elements[i]);
//				
//		}
//		for (int i = 0; !stack.IsEmpty(); ++i) {
//			elements[i] = stack.Pop();
//		}
//	}

	public static void main(String[] args) {
			int[] arr = {1, 2, 3, 4, 5};
			System.out.println("Original array: " + Arrays.toString(arr));
			StackUsingList stackObj = new StackUsingList(6);
			try {
//				Reverse(arr, stackObj);
				 stackObj.Push(5);
				 stackObj.Push(6);
				 stackObj.Push(2);
				 stackObj.Push(3);
				 stackObj.Push(7);
				 stackObj.Push(3);
				 System.out.println(stackObj.Pop());
				 System.out.println(stackObj.Pop());
				 System.out.println(stackObj.Pop());
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SListExceptions e) {
				e.printStackTrace();
			}
			System.out.println("Reverse array: " + Arrays.toString(arr));
	}
}
