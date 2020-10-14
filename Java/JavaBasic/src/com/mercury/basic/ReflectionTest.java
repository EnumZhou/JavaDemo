package com.mercury.basic;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

// use reflection to change String immutable class
public class ReflectionTest {
	
	public static void main(String args[]) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		List list=new LinkedList<String>();
		list.add("Gender: M");
		List newList=new LinkedList<String>();
		newList.add("Gender: W");
		
		MyImmutable mi=new MyImmutable(12,"I am Bob",list);
		
		System.out.println("Old id: "+mi.getId());
		System.out.println("Old name: "+mi.getName());
		System.out.println("Old information: "+mi.getInfo().toString());
		
		
		//Use Field to reflect id and change the immutable id value
		Field idField=mi.getClass().getDeclaredField("id");
		idField.setAccessible(true);
		idField.set(mi, 24);
	
		//Use Field to reflect name and change the immutable name value
		Field nameField=mi.getClass().getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(mi, "Now I am Lee");
		
		//Use Field to reflect info and change the immutable info value
		Field inforField=mi.getClass().getDeclaredField("info");
		inforField.setAccessible(true);
		inforField.set(mi,newList );
		
		System.out.println("New id: "+mi.getId());
		System.out.println("New name: "+mi.getName());
		System.out.println("New Inforamtion:"+mi.getInfo().toString());
	}

}
