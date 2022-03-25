import java.util.Arrays;

public class mainApp {

	public static void main(String[] args) {
		int[] arr = {10, 4, 3, 1, 9, 5, 17, 90, 6, 2};
		SortingAlgos sObj = new SortingAlgos();

//		System.out.println("Unsorted array = " + Arrays.toString((arr)));
//		sObj.MergeSortDesc(arr);
//		System.out.println("Sorted array   = " + Arrays.toString((arr)));
		sObj.QuickSortAsc(arr);
		System.out.println("Sorted array   = " + Arrays.toString((arr)));
	}

}
