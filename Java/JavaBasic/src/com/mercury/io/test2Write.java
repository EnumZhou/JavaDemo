package com.mercury.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class test2Write {

	public static void main(String[] args) {
		try (FileOutputStream fos=new FileOutputStream("resources/test2.dat");
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				DataOutputStream dos=new DataOutputStream(bos)
				){
			int i=-5;
			double d=3.1415926;
			boolean b=true;
			dos.writeInt(i);
			dos.writeDouble(d);
			dos.writeBoolean(b);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
