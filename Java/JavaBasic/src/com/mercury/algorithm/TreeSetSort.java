package com.mercury.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetSort {
	
	public Set<Integer> saveToHashSetFromArray(int [] arr) {
		Set<Integer> hash_set=new HashSet<Integer>();
		
		for(int i=0; i<arr.length;i++) {
			hash_set.add(arr[i]);
		}
		return hash_set;
	}
	
	public static void main (String args[]) {
		int arr[] = {10,50,30,70, 80, 60, 40,20};
		
		TreeSetSort ts=new TreeSetSort();
		Set<Integer> hash_set=ts.saveToHashSetFromArray(arr);
		Set<Integer> tree_set=new TreeSet<Integer>(hash_set);
		System.out.println(tree_set);
		
		
	}

}
