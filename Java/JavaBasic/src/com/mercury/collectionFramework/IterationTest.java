package com.mercury.collectionFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class IterationTest {
	
	public static void iterateArray(){
		int []nums={1,2,3,4};
		//1. traditional for loop
//		for(int i=0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
		
		//2. enhanced for loop
//		for(int i: nums){
//			System.out.println(i);
//		}
        // 3. iterator --not iterable
		// 4. forEach() --no such function
		// 3 and 4 works on collection framework
	}
	
	
	public static void iterateList(){
		List<Integer> nums=new ArrayList();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		// 1. traditional for loop
//		for(int i=0;i<nums.size();i++)
//		{
//			System.out.println(nums.get(i));
//		}
//		
		// 2. enhanced for loop
		
//		for(int i: nums)
//		{
//			System.out.println(i);
//		}
//		
		// 3.iterator
//		Iterator<Integer> i=nums.iterator();
//		while(i.hasNext())
//		{
//			Integer nextVal=i.next();
//			System.out.println(nextVal);
//		}
		// 4. forEach()
		//Consumer c= e-> System.out.println(e);
		nums.forEach(e-> System.out.println(e));
		
	}
	
	public static void iterateSet(){
		Set<Integer> nums=new HashSet();
		nums.add(1111);
		nums.add(2222);
		nums.add(3333);
		nums.add(4444);
		
		// 1. traditional for loop
		// no index, no traditional for loop
//		for(int i=0;i<nums.size();i++)
//		{
//			
//			System.out.println();
//		}
		
		// 2. enhanced for loop
		
//		for(int i: nums)
//		{
//			System.out.println(i);
//		}
		
		
		
		// 3.iterator
//				Iterator<Integer> i=nums.iterator();
//				while(i.hasNext())
//				{
//					Integer nextVal=i.next();
//					System.out.println(nextVal);
//				}
		
		// forEach
		nums.forEach(x-> System.out.println(x));
		
		
			
	}
	
	public static void iterateMap(){
		Map<Integer,String> hm=new HashMap();
		hm.put(1,"Ann");
		hm.put(2,"Boo");
		hm.put(3,"Lee");
		hm.put(4,"Jayce");
		// 1. loop the keySET();
//		Set<Integer> ks=hm.keySet();
//		for(int key: ks){
//			System.out.println(key+"---"+hm.get(key));
//		}
		//for loop entrySet
		Set<Map.Entry<Integer, String>> es=hm.entrySet();
//		for(Map.Entry<Integer, String> me:es)
//		{
//			System.out.println(me.getKey()+"-->"+me.getValue());
//		}
		
		//Iterator entrySet
//		Iterator<Map.Entry<Integer, String>> iter=es.iterator();
//		while(iter.hasNext())
//		{
//			Map.Entry<Integer, String> me=iter.next();
//			System.out.println(me.getKey()+"--->"+me.getValue());
//		}
		
		hm.forEach((k,v)->
					System.out.println(k+"--->"+v)
				
				);
		
				
				
				
		
		
		//2. loop the entrySet();
//		Set<Map.Entry<Integer, Integer>> es=hm.entrySet();
//		Iterator<Map.Entry<Integer,Integer>> i=es.iterator();
//		while(i.hasNext()){
//			Map.Entry<Integer,Integer> me=i.next();
//			System.out.println(me.getKey()+"----> "+me.getValue());
//			
//		}
		
		// 3. enhanced for loop
//		for(Map.Entry<Integer,Integer> me:es){
//			System.out.println(me.getKey() +" ----> "+ me.getValue());
//		}
////		
		
		// 4. forEach
		
//		hm.forEach((k,v)-> 
//		{
//			System.out.println("key: "+k);
//			System.out.println("value: "+v);
//			
//		}
//		
//		);
		
		
				
		
	}
	
	public static void main(String[] args){
		//iterateList();
		//iterateSet();
		iterateMap();
	}

}
