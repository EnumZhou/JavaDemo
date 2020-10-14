package com.mercury.basic;

import com.mercury.basic.oop.User;

public class TestFinal {
	
	//final is a keyword, can be put in front of a class/ a function/ a field
	// 1. final class cannot be extended
	// 2. final function cannot be overridden
	// 3. final field cannot be modified/ reassigned
	
	
	
	// Assign value to a static field
	
	// 1. Assign when define
	
	 static final int X=2;
	
	// 2. Assign in static block
	 static final int Y;
	static {
		Y=5;
	}
	
	// Assign value to a non-static field
	// 1. Assign when define
	final int c=3;
	
	// 2. Assign in block
	final int d;
	{
		d=2;
	}
	
	// 3. Assign in all constructors
	final int e;
	
	final User u;
	public TestFinal(){
		e=2;
		u=new User();
	}
	
	public TestFinal(int x){
		e=x;
		u=new User();
	}
	
	public static void main (String args[]){
		TestFinal tf=new TestFinal();
		System.out.println(tf.u.name);
		
	}
}
