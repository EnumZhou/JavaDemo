package com.mercury.basic;

public class InnerClassTest {

	public static void main(String[] args) {
		// because static inner class is also class level
		//so it can be treated as a regular outer class
		OuterClass.InnerClass1 oi1=new OuterClass.InnerClass1();
		OuterClass oc=new OuterClass();
		OuterClass.InnerClass2 oi2=oc.new InnerClass2();
	}

}
