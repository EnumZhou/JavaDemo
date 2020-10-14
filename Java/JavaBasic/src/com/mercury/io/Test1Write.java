package com.mercury.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test1Write {
	
	public static class MyResource implements AutoCloseable{
		@Override
		public void close() throws Exception{
			System.out.println("Closing MyResource....");
		}
		
	}
	
	public static void main(String[] args){
		try (FileOutputStream fos=new FileOutputStream("resources/test1.dat")
				){
			int[] nums={-1,2,3,4,729538};
			for(int i=0;i<nums.length;i++){
				fos.write(nums[i]);
			}
			System.out.println("Test 1 write complete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
