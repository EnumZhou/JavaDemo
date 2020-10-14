package com.mercury.threads.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentBasic {
	
	public static class DummyTask implements Runnable{
		private int id;
		
		public DummyTask(int id) {
			super();
			this.id = id;
		}

		@Override
		public void run(){
			System.out.println(Thread.currentThread().getName()+" ->"+ id);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	public static void testThreadPool(){
		//ExecutorService es=Executors.newCachedThreadPool();
		ExecutorService es=Executors.newFixedThreadPool(5);
		for(int i=0; i<20;i++){
			es.submit(new DummyTask(i));
		}
		es.shutdown();
	}
	
	public static class Producer implements Runnable{
		private BlockingQueue bq;
		
		public Producer(BlockingQueue bq) {
			super();
			this.bq = bq;
		}

		@Override
		public void run(){
			for(int i=0;i<100;i++){
				try {
					bq.put(i);
					System.out.println("Producing: "+i);
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
	public static class Consumer implements Runnable{
		private BlockingQueue bq;
		
		public Consumer(BlockingQueue bq) {
			super();
			this.bq = bq;
		}

		@Override
		public void run(){
			try {
				Thread.sleep(2000);
				while(!bq.isEmpty()){
					System.out.println("Consuming---------->" + bq.take());
					Thread.sleep(3000);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		//testThreadPool();
		BlockingQueue bq=new LinkedBlockingQueue(5);
		Producer p=new Producer(bq);
		Consumer c=new Consumer(bq);
		
		new Thread(p).start();
		new Thread(c).start();

	}

}
