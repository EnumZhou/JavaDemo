package com.mercury.io;

import java.io.FileInputStream;

public class Test1Read {
	public static void main(String[] args){
		try(FileInputStream fis=new FileInputStream("resources/test1.dat")){
			int x=fis.read(); //0-255
			while(x!=-1){//-1 if reach the end of the file (EOF)
				System.out.println(x);
				x=fis.read();
			}
			//1.bitwise operation
			// int y=729538>>8<<8;
			//System.out.println(729538-y);
			
			//2. mod
			System.out.println("*******");
			System.out.println(729538 % 256);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
