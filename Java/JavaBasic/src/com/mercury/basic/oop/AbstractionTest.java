package com.mercury.basic.oop;

public class AbstractionTest {
	
	abstract public static class Par{
		
		//abstract: unimplemented-unfinished
		// can only be added in front of a class/function
		public void foo(){
			//empty implementation
		}
		//abstract method must don't have body
		//methods in abstract class must have keywords abstract
		abstract public void bar();
	}
	
	
	
	//concrete class can't have abstract method
	public static class A extends Par{
		@Override
		public void bar(){
			
		}
	}
	
	//abstract class can extend abstract
	abstract public static class B extends Par
	{
		
	}
	
	//abstract class can extend concrete class
	abstract public class C extends A{
		
	}

	public static void main(String[] args) {
		

	}

}
