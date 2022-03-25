import java.util.Arrays;
import java.util.Scanner;

public class SortingAlgos {
	public static void BubbleSort(int[] arr) {
		// Set elementToFindPos to N - 1
		int elementToFindPos = arr.length - 1;

		// while (elementToFindPos > 0) do
		while (elementToFindPos > 0) {
			// Set i to 0
			int i = 0;

			// while ( i < elementToFindPos) do
			while (i < elementToFindPos) {
				// if (arr[i] > arr[i + 1]) then
				if (arr[i] > arr[i + 1]) {
					// Swap i and i+1 elementToFinds of arr
					int t = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = t;
				}

				// Increment i by 1
				++i;
			}

			// Decrement elementToFindPos by 1
			--elementToFindPos;
		}
	}
	
	public static void BubbleSortDesc(int[] arr) {
		// Set elementToFindPos to N - 1
		int elementToFindPos = arr.length - 1;

		// while (elementToFindPos > 0) do
		while (elementToFindPos > 0) {
			// Set i to 0
			int i = 0;

			// while ( i < elementToFindPos) do
			while (i < elementToFindPos) {
				// if (arr[i] > arr[i + 1]) then
				if (arr[i] < arr[i + 1]) {
					// Swap i and i+1 elementToFinds of arr
					int t = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = t;
				}

				// Increment i by 1
				++i;
			}

			// Decrement elementToFindPos by 1
			--elementToFindPos;
		}
	}
	
	public static boolean LinearSearch(int[] arr, int elementToFindToFind) {
		int i = 0;
		while(i< arr.length) {
			if(arr[i] == elementToFindToFind)
				return true;
			i++;
		}
		return false;
	}

	public static boolean BinarySearch(int[] arr, int elementToFind) {
		int left =0;
		int right = arr.length-1;
		while (left <= right) {
			int mid = (right+left)/ 2;
			if(arr[mid] == elementToFind)
				return true;
			else if(arr[mid] < elementToFind)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return false;
		
	}
	public static void BubbleSortAsc(int[] arr) {
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
		try(Scanner sc = new Scanner(System.in)) {
			int[] arr = {10, 4, 3, 1, 9, 5, 17, 90, 6, 2};
	
			System.out.println("Unsorted array = " + Arrays.toString((arr)));
			BubbleSort(arr);
			System.out.println("Sorted array   = " + Arrays.toString((arr)));
			BubbleSortDesc(arr);
			System.out.println("Sorted array Descending order  = " + Arrays.toString((arr)));
			System.out.println("Enter Element to find :");
			if(LinearSearch(arr, sc.nextInt()))
				System.out.println("Element found");
			else
				System.out.println("Elemment not found");
			BubbleSort(arr);
			System.out.println("Enter Element to find :");
			if(BinarySearch(arr, sc.nextInt()))
				System.out.println("Element found");
			else
				System.out.println("Element not found");
			
			BubbleSortAsc(arr);
			System.out.println("Sorted array   = " + Arrays.toString((arr)));
			
		}
	}
}
