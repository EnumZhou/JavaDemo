package com.mercury.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.mercury.beans.CommunicationChannel;

public class Test3Write {

	public static void main(String[] args) {
		CommunicationChannel cc=new CommunicationChannel("Phone",10,"12345678");
		try (FileOutputStream fos=new FileOutputStream("resources/test3.dat");
				ObjectOutputStream oos=new ObjectOutputStream(fos);)
				{
			oos.writeObject(cc);
			System.out.println("Test 3 write complete");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
