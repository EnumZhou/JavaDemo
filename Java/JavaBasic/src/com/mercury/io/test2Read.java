package com.mercury.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class test2Read {

	public static void main(String[] args) {
		//Design Pattern: Decorator
		try (FileInputStream fis=new FileInputStream("resources/test2.dat");
				BufferedInputStream bis=new BufferedInputStream(fis);
				DataInputStream dis=new DataInputStream(bis)
				){
			
			int i=dis.readInt();
			double d=dis.readDouble();
			boolean b=dis.readBoolean();
			System.out.println(i);
			System.out.println(d);
			System.out.println(b);
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
