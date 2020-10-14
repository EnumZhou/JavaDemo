package com.mercury.algorithm;

public class MinLengthSubArray {
	
	static int smallestSubWithSum(int [] arr, int target) {
		int min_len=arr.length+1;
		
		for(int start=0; start<arr.length; start++) {
			int curr_sum = arr[start];
			
			if(curr_sum>target) return 1;
			
			for (int end=start+1; end<arr.length; end++) {
				curr_sum +=arr[end];
				
				if(curr_sum>target && (end-start+1)< min_len) {
					min_len=end-start+1;
				}
			}
			System.out.println("min-length: "+ min_len);
		}
		
		return min_len;
	}
	
	public static void main  (String  args[]) {
		int [] arr= {1, 4, 45, 6, 0, 19};
		System.out.println(MinLengthSubArray.smallestSubWithSum(arr, 51));
		
	}

}
