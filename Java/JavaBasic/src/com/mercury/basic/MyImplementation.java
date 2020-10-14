package com.mercury.basic;


public class MyImplementation implements MyInterface{
	
	
	@Override
	public void foo(){
		System.out.println("Sub foo");
	}
	
	@Override
	public void yam(){
		System.out.println("Sub yam!");
	}
	
	public static void main (String args[]){
		MyImplementation mi=new MyImplementation();
		mi.foo();
		mi.yam();
		MyInterface.bar();
	}
	

}
