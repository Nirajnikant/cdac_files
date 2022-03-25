
import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] =  {5,3,8,6,4,1};
		HeapSort hp=new HeapSort();
		hp.HeapSort(arr);
		System.out.println("Heap Sort ascending order=>"+Arrays.toString(arr));
		hp.HeapSortDes(arr);
		System.out.println("Heap Sort Descending order=>"+Arrays.toString(arr));
	}
	
	
	public void HeapSort(int arr[]) {
		
		int n=arr.length;
		
		for(int i=(n/2)-1; i>=0 ;i--)
		{
			MaxHeap(arr,n,i);
		}
		for(int i=n-1;i>0;i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			MaxHeap(arr,i,0);
		}
		
	}
	
	
	
public void HeapSortDes(int arr[]) {
		
		int n=arr.length;
		
		for(int i=(n/2)-1; i>=0 ;i--)
		{
			MinHeap(arr,n,i);
		}
		for(int i=n-1;i>0;i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			MinHeap(arr,i,0);
		}
		
	}
	
	public void MaxHeap(int arr[],int n,int i)
	{
		int largest = i;
		int left = 2*i+1;
		int right=2*i+2;
		
		if(left<n && arr[left] > arr[largest])
		{
			largest=left;
		}
		
		if(right < n && arr[right] > arr[largest])
		{
			largest=right;
		}
		
		if(largest != i)
		{
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			MaxHeap(arr,n,largest);
		}
	}

	
	public void MinHeap(int arr[],int n,int i)
	{
		int largest = i;
		int left = 2*i+1;
		int right=2*i+2;
		
		if(left<n && arr[left] < arr[largest])
		{
			largest=left;
		}
		
		if(right < n && arr[right] < arr[largest])
		{
			largest=right;
		}
		
		if(largest != i)
		{
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			MinHeap(arr,n,largest);
		}
	}

}