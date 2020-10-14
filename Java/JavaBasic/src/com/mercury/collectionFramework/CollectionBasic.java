package com.mercury.collectionFramework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import com.mercury.beans.Iphone;

public class CollectionBasic {
	
	public static int getCapacity(List l){
		int capacity=0;
		try {
			Field capacityField=l.getClass().getDeclaredField("elementData");
			capacityField.setAccessible(true);
			try {
			      capacity=((Object[]) capacityField.get(l)).length;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return capacity;
	}

	public static void main(String[] args) {
	// [I for array className	
//		int x=2;
//		int [] nums={1,2,3};
//		System.out.println(nums.getClass().getName());
		
		//generic: restrict the element type of the collection
		List al=new ArrayList();
		al.add(new Integer(1));
		al.add("hhhh");
		al.add(null);
		
		System.out.println("ArrayList Old Capacity: "+getCapacity(al));// deflault capacity=10
		
		List al2=new ArrayList();
		for(int i=0;i<14;i++)
		{
			al2.add(i);
		}
		al.addAll(al2);// 16, First old capacity *1.5, if not enough, old capacity +new size added.// 16
		System.out.println("ArrayList New Capacity: "+getCapacity(al));
		
		
		//Generic and Wrapper classes of primitive types were introduced into java at same time
		
		
		//java does auto-boxing and auto-unboxing
		int y=new Integer(2); //unboxing
		Integer j=3; //boxing
		
		// Integer -int
		//Character -char
		//Byte -byte
		//Boolean -boolean
		
		//1. Vector is thread-safe, so performance bad (vs ArrayList)
		// 2. default init capacity is 10 (ArrayList is 0, add will increased to 10)
		//3. default resizing rate is 2 (ArrayList is 1.5)
		// 4.
		List v=new Vector(10,2); //init=10, increment capacity+2 Like ArrayList if not enough, 
		//we have to add to enough space;
		v.add(1);
		v.add(null);
		System.out.println("Vector Old Capacity: "+getCapacity(v));
		List al3=new ArrayList();
		for(int i=0;i<14;i++)
		{
			al3.add(i);
		}
		v.addAll(al3);
		System.out.println("Vector Old Capacity: "+getCapacity(v));
		
//		System.out.println(v);
		
		List ll= new LinkedList();
		
		Map m =new HashMap();
		m.put(null, 1);
		m.put(123, null);
		
		System.out.println(m);
		
		
		// 1. thread safe (HM is not thread safe)
		// 2. performance bad (VS HashMap)
		// 3. not allows null key, nor null value
		
		Map ht= new Hashtable();
		//ht.put(null, 123);
		//ht.put(123, null);
		
		//System.out.println(ht);
		
		Map chm = new ConcurrentHashMap();
		
		// LinkedHashMap will keep insertion order
		//HashMap +LinkedList
		Map lhm=new LinkedHashMap();
		
		// tree: Rb-Tree (Self balanced binary search three)
		// sorted by the key
//		Map tm= new TreeMap();
//		tm.put(3, "a");
//		tm.put(1, "a");
//		tm.put(2, "a");
		
		//annoymomus implementation -one time use only
		// Generic on left restrict the reference
		Comparator<Iphone> c=new Comparator<Iphone>(){
			//implemented interface - concrete
			@Override
			public int compare(Iphone o1,Iphone o2){
				return o2.getCapacity()-o1.getCapacity();
			}
		};
		
		
		
		
		// Comparator has higher priority than Comparable
		//Map tm= new TreeMap(c);
		Map tm=new TreeMap();
		tm.put(new Iphone("x","Black",64), "a");
		tm.put(new Iphone("x","Golden",128), "a");
		tm.put(new Iphone("x","White",256), "a");
		System.out.println(tm);
		
		Set hs=new HashSet();
		hs.add("abc");
		System.out.println(hs);
		
		
		
	}

}
