package com.mercury.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest {
	
	
	
	
	
	public static void main (String args[]) {
		int arr[]= {2,7,3,5,1,9,12,10};
		List<Integer> myList=new ArrayList<Integer>();
		Stream<Integer> myStream =myList.stream();
		for(int i=0;i<arr.length;i++) {
			myList.add(arr[i]);
		}
		
//		List<Integer> sortedList = myList.stream()
//				.sorted(Comparator.reverseOrder())
//				.collect(Collectors.toList());
		
//		List<Integer> sortedList=myList.stream()
//								.sorted(Comparator.reverseOrder())
//								.collect(Collectors.toList());
//		
//		sortedList.forEach(e -> System.out.println(e));
								
		//Sort with stream API
		myStream.sorted().forEach(e -> System.out.println(e));
		
	}
}
