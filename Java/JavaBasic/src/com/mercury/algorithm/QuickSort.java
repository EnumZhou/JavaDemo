package com.mercury.algorithm;

public class QuickSort {
	
	public int partition (int arr[], int low, int high) {
		int privot = arr[high];
		int i=low-1; // index of smaller element;
		
		for(int j=low;j<high;j++) {
			if(arr[j] < privot) {
				i++;
				// swap arr[i] and arr[j]
				int temp = arr [i];
				arr [i] = arr[j];
				arr [j] = temp;
			}
			
		}
		
		// swap arr[i+1] and arr[high]
		
		int temp=arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
	
	public void sort(int arr[], int low, int high) {
		if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
	}
	
	 /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
	
	
	public static void main(String args[]) {
		
		int arr[] = {10,50,30,70, 80, 60, 40,20};
		QuickSort qs=new QuickSort();
		
		qs.sort(arr, 0, arr.length-1);
        System.out.println("sorted array"); 
        printArray(arr); 
	}
	
}
