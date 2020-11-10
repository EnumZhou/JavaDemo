package com.mercury.basic;

public class InnerClassTest {

	public static void main(String[] args) {
		// because static inner class is also class level
		//so it can be treated as a regular outer class
		
		//static Inner class
		OuterClass.InnerClass1 oi1=new OuterClass.InnerClass1();
		oi1.foo1();
		
		// non-static Inner class
		OuterClass oc=new OuterClass();
		OuterClass.InnerClass2 oi2=oc.new InnerClass2();
		
		oi2.foo2();
	}

}
