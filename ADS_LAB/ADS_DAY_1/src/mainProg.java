import java.util.Arrays;

import custom_exception.*;

public class mainProg {
	public static void Reverse(int[] elements, StackIntf stack) throws StackException {
		for (int i = 0; i < elements.length; ++i) {
				stack.Push(elements[i]);
				
		}
		for (int i = 0; !stack.IsEmpty(); ++i) {
			elements[i] = stack.Pop();
		}
	}

	public static void main(String[] args) {
			int[] arr = {1, 2, 3, 4, 5};
			System.out.println("Original array: " + Arrays.toString(arr));
			StackUsingArray stackObj = new StackUsingArray(10);
			try {
				Reverse(arr, stackObj);
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reverse array: " + Arrays.toString(arr));
	}
}
