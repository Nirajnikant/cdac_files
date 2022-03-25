import java.util.Arrays;

public class SortingAlgos {
	public static void InsertionSort(int[] arr) {
		int sortedArraySize;

		// for sortedArraySize = 1; sortedArraySize < N; ++sortedArraySize
		for (sortedArraySize = 1; sortedArraySize < arr.length; ++sortedArraySize) {
			// Set newElement to arr[sortedArraySize]
			int newElement = arr[sortedArraySize];
			
			// set i to sortedArraySize - 1
			int i = sortedArraySize - 1;
			
			// while (i >= 0) do
			while (i >= 0) {
				// if (newElement > arr[i]) then
				if (newElement < arr[i]) {
					// Found ith position to right of which to add newElement
					// End the loop
					break;
				}
				
				// Shift ith element one place to its right
				arr[i + 1] = arr[i];
				
				// Decrement i by 1
				--i;
			}
			
			// Set newElement at arr[i + 1]
			arr[i + 1] = newElement;
		}
	}

	public static void InsertionSortWithLoopCount(int[] arr) {
		int sortedArraySize;
		int loopCount  = 0;

		// for sortedArraySize = 1; sortedArraySize < N; ++sortedArraySize
		for (sortedArraySize = 1; sortedArraySize < arr.length; ++sortedArraySize) {
			// Set newElement to arr[sortedArraySize]
			int newElement = arr[sortedArraySize];
			
			// set i to sortedArraySize - 1
			int i = sortedArraySize - 1;
			
			// while (i >= 0) do
			while (i >= 0) {
				++loopCount;

				// if (newElement > arr[i]) then
				if (newElement > arr[i]) {
					// Found ith position to right of which to add newElement
					// End the loop
					break;
				}
				
				// Shift ith element one place to its right
				arr[i + 1] = arr[i];
				
				// Decrement i by 1
				--i;
			}
			
			// Set newElement at arr[i + 1]
			arr[i + 1] = newElement;
		}

		System.out.println("Loop count is = " + loopCount);
		
		
	}
	public static void SelectionSortAsc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	public static void main(String[] args) {
		int[] arr = {10, 4, 3, 1, 9, 5, 17, 90, 6, 2};

		System.out.println("Unsorted array = " + Arrays.toString((arr)));
		InsertionSortWithLoopCount(arr);
		System.out.println("Sorted array   = " + Arrays.toString((arr)));
		
		InsertionSort(arr);
		System.out.println("Sorted array   = " + Arrays.toString((arr)));
		
		SelectionSortAsc(arr);
		System.out.println("Sorted array   = " + Arrays.toString((arr)));
	}
}
