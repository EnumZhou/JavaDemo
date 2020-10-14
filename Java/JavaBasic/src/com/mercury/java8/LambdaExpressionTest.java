package com.mercury.java8;

public class LambdaExpressionTest {
	public static interface A{
		void bar();
	}
	
	public static interface B{
		void foo(int i);
	}
	
	public static interface C{
		void foo(int i, String s);
	}
	public static interface D{
		int foo();
	}
	public static class AImpl implements A{
		@Override
		public void bar(){
			System.out.println("AImpl bar()");
		}
		
		public void foo(D d)
		{
			System.out.println("----> "+d.foo());
		}
	}
	
	public static void main(String[] args){
		AImpl a1=new AImpl();
		//lambda expression
		a1.foo(()->100);
		//anonoymous
		a1.foo(new D(){
			@Override
			public int foo(){
				return 100;}
			});
		
		A a2=new AImpl(){
			@Override
			public void bar(){
				System.out.println("Anonymous A");
			}
		};
		
		//Lambda expression is trying to do same by easy way of anoymous 
		
		A a3= ()->System.out.println("Lambda");
		B b =y->System.out.println(y);
		C c=(i,s)->{System.out.println(i);
					System.out.println(s);
			};
			
		D d=() -> 1;//return 1;
		Runnable r=()->System.out.println("Runnable ");
		
		
		System.out.println("*******");
		
		
		
		
	
		
	}
}
