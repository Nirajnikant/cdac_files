import java.util.Arrays;

public class SortingAlgos {
	int[] MergeDescdArray;
	int[] quickSortedArray;

	private void MergeDesc(int[] arr, int startPos1, int endPos1, int startPos2, int endPos2) {
		int i = startPos1;
		int j = startPos2;
		int k = 0;

		while ((i <= endPos1) && (j <= endPos2)) {
			if (arr[i] > arr[j]) {
				MergeDescdArray[k] = arr[i];
				++i;
			} else {
				MergeDescdArray[k] = arr[j];
				++j;
			}
			++k;
		}
		while (i <= endPos1) {
			MergeDescdArray[k] = arr[i];
			++i;
			++k;
		}
		while (j <= endPos2) {
			MergeDescdArray[k] = arr[j];
			++j;
			++k;
		}
		i = startPos1;
		j = 0;
		while (j < k) {
			arr[i] = MergeDescdArray[j];
			++i;
			++j;
		}
	}

	private void MergeSortDesc(int[] arr, int startPos, int endPos) {
		int elementCount = (endPos - startPos + 1);
		if (elementCount <= 1) {
			return;
		}

		int middlePos = (startPos + endPos) / 2;

		MergeSortDesc(arr, startPos, middlePos);
		MergeSortDesc(arr, middlePos + 1, endPos);

		MergeDesc(arr, startPos, middlePos, middlePos + 1, endPos);
	}

	public void MergeSortDesc(int[] arr) {
		MergeDescdArray = new int[arr.length];

		MergeSortDesc(arr, 0, arr.length - 1);
	}
	
	
	
	public void QuickSortAsc(int[] arr) {
		QuickSort(arr, 0, arr.length-1);
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[i] = temp;
	}
	
	public void QuickSort(int[] arr, int start, int end) {
		if(start >= end)
			return;
		int k = pivot(arr, start, end);
		QuickSort(arr, start, k-1);
		QuickSort(arr, k+1, end);
	}
	
	public int pivot(int[] arr, int start, int end) {
		int i = start-1;
		for(int j = start; j< end; j++)
			if(arr[j]<arr[end])
				swap(arr, ++i, j);
		swap(arr, ++i, end);
		return i;
	}
}
