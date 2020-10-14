package com.mercury.threads;

public class ThreadBasic {
	
	//How many ways to start a thread i java
	//2 ways
	// 1. extends Thread, override run() and start the thread from its object by calling run();
	// 2. implements Runnable, override run(), and start the thread from a new Thread object, by calling start().
	
	
	public static class MyThread extends Thread{
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+" in run()");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" finished in run()");
		}
	}
	
	public static class MyRunnableImpl implements Runnable{
		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+" in run()-MyRunnableImpl");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" finished in run()-MyRunnableImpl");
		}
	}
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName()+" started");
//		MyThread mt=new MyThread();
//		mt.run();
		
		/*
		 * main started
		Thread-0 in run()
		main finished
		Thread-0 finished in run()
		 * 
		 * */
		//JVM shut down if only daemon thread exist
		//GC is a daemon thread
//		mt.setDaemon(true); 
//		mt.start();
		
		MyRunnableImpl mri=new MyRunnableImpl();
		Thread t=new Thread(mri);
		t.start();
//		new Thread(mri).start();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName()+" finished");
	}

}
