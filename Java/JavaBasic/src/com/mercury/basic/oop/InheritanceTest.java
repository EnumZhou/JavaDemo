package com.mercury.basic.oop;

public class InheritanceTest {
	
	public static class Par{
		
		public void foo(){
			System.out.println("Par foo");
		}
		
		public static void bar(){
			System.out.println("Par bar");
		}
	}
	
	public static class Sub extends Par{
		@Override
		public  void foo(){
			System.out.println("Sub foo");
		}
		
		/*********static function cannot be overridden*********/
		public static void bar(){
			System.out.println("Sub bar");
			
		}
		public void yam(){
			System.out.println("hhhh");
		}
	}
	

	public static void main(String[] args){
		Sub.bar();
//		Par p2=new Sub();
//		Par p3=(Par)p2;
//		p2.foo();
//		p3.foo();
		
		//p.foo();
		
		
		//Par s=new Sub();
		//s.foo();
		
		// sub is a parent.
		//Sub.bar();
	}
}
