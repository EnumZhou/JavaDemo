package com.mercury.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.mercury.beans.CommunicationChannel;

public class Test3Read {
	public static void main(String[] args) {
		try(FileInputStream fis=new FileInputStream("resources/test3.dat");
				ObjectInputStream ois=new ObjectInputStream(fis)){
				//CommunicationChannel.isAvailable=false;
				
				CommunicationChannel cc=(CommunicationChannel)ois.readObject();
				CommunicationChannel cc2=cc.clone();
				System.out.println(cc);//isAvaliable=false cause static-field is NOT Serializable
				//System.out.println(cc2);
				System.out.println(cc==cc2);
				System.out.println(cc.getType()==cc2.getType());
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
