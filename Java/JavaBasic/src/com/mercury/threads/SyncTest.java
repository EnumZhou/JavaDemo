package com.mercury.threads;

public class SyncTest {
	//Every class & object contain a lock
	// if a static function is sync, to execute it, you need the class lock
	// if a non-static function is sync, to execute it, you need the object lock
	// if lock is holding by other thread, you have to wait until the lock is released.
	
	// if a function is not sync, no need lock, always directly execute
	
	
	//	static int x=0;
	
	
	//synchronized is a keyword can be added in front of a function/ code block in function
	synchronized public static void foo(){
		System.out.println(Thread.currentThread().getName()+" in foo()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		x++;
		System.out.println(Thread.currentThread().getName()+" finished foo()");
	}
	
	synchronized public static void bar(){
		System.out.println(Thread.currentThread().getName()+" in bar()");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" finished bar()");
	}
	
	public  void yam(){
		System.out.println(Thread.currentThread().getName()+" in yam()");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" finished yam()");
	}
	public void doo(){
		System.out.println(Thread.currentThread().getName()+" in doo()");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" finished doo()");
	}
	
	
	public static class MyThread extends Thread{
		
		SyncTest st;
		@Override
		public void run(){
//			SyncTest.foo();
			st.yam();
			
		}
	}

	public static void main(String[] args) {
		
		SyncTest st=new SyncTest();
		MyThread mt=new MyThread();
		
		mt.st=st;
		
		mt.start();
		
		SyncTest.bar();
		
//		try {
//			
//			//main will wait until the thread created from mt to complete, then continue.
//			mt.join();
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		
//		System.out.println(x);
		

	}

}
