package com.mercury.basic.oop;

public class Accessibility {
	
	//1.Invoke the function
	//public can be invoked anywhere
	//protected/package can only be invoked within same package
	//protected can be invoked within subclass out of package
	//private can only be accessed on the same class
	
	//2.Override
	//public can be overridden from anywhere
	//protected can be overridden from anywhere
	//package can only be overridden within same package
	//private cannot be overridden
	
	public static void f1(){System.out.println("static f1");}
	protected static void f2(){System.out.println("static f2");}
	static void f3(){System.out.println("static f3");}
	private static void f4(){System.out.println("static f4");}
	
	
	//2. Have to new an object to call the following function and followed the 1. rules
	public void f5(){System.out.println("Non-static f5");}
	protected  void f6(){System.out.println("Non-static f6");}
	void f7(){System.out.println("Non-static f7");}
	private void f8(){System.out.println("Non-static f8");}
	

}
