package com.mercury.basic;
// 4 elements : field, method, {}, and innnerClass
public class OuterClass {
	int x=3;
	public void foo(){
		
	}
	
	static {}
	
	public static class InnerClass1{
		public static void foo1() {
			System.out.println("static Class");
		}
	}
	
	public class InnerClass2{
		public void foo2() {
			System.out.println("no-static Class");
		}
	}

}
