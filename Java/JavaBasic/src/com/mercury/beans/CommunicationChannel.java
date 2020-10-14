package com.mercury.beans;

import java.io.Serializable;

//Pojo/Java Bean class
public class CommunicationChannel implements Serializable,Cloneable{
	
	
	//static field will NOT be serialized
	
	//serialization only serialize object level information
	public static boolean isAvailable=true;
	
	//except only 1 static field: serialVersionUID can be serialized
	private static final long serialVersionUID=923560278347537L;
	
	private String type;
	private int compacity;
	transient private String password; //transient will hide this field from serialization
	public CommunicationChannel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommunicationChannel(String type, int compacity,String password) {
		super();
		this.type = type;
		this.compacity = compacity;
		this.password=password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCompacity() {
		return compacity;
	}
	public void setCompacity(int compacity) {
		this.compacity = compacity;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CommunicationChannel [type=" + type + ", compacity=" + compacity + ", password=" + password + "] " +isAvailable;
	}
	
	
	@Override
	public CommunicationChannel clone() {
		CommunicationChannel cc=null;
		try {
		     cc=(CommunicationChannel)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cc;
	}
	
	
	

}
