package com.mercury.basic.oop;

public class ClassInheritanceTest {

	  static public class A {
		  public void foo() {
			System.out.println("AAAAAAA");
		}
	}

	 public class B extends A {
		 @Override
		 public void foo(){
		 System.out.println("BBBBBB");
		 }
	}

	public class C extends B {
		@Override
		 public void foo(){
		 System.out.println("CCCCCC");
		 }
		
		public void bar(){
			System.out.println("barrrrrrrr");
		}
		
		public void hhhh(){
			bar();
		}
	}

	public static void main(String[] args) {
		ClassInheritanceTest test = new ClassInheritanceTest();
     	ClassInheritanceTest.A a ;
		ClassInheritanceTest.C b;
		// a=test.new A();
		// b=test.new B();
		// c=test.new C();
		// a.foo();
		// b.foo();
		// c.foo();
		a=new ClassInheritanceTest().new C();
		a=test.new C();
		a.foo();

	}

}
