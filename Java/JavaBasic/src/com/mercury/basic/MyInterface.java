package com.mercury.basic;


//changed since java 1.8
public interface MyInterface {
	//all fields in interface are public static final by default
	int X=2;
	
	//only public abstract (by default) function is allowed in interface
	void foo(); //public abstract void foo()
	static void bar(){
		System.out.println("MyInterface static");
	}
	
	default void yam(){
		
		System.out.println("MyInterface default");
	}
}
