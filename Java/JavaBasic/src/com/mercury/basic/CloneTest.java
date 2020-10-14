package com.mercury.basic;

import com.mercury.beans.Player;

public class CloneTest {

	public static void main(String[] args) {
		Player p1=new Player(1,"Ramos","Real Madrid");
		
		Player p2=p1.clone();
		
		System.out.println(p1);
		System.out.println(p2);
		//cause created two new object and points two different address
		System.out.println(p1==p2);//false
		
		//pointing to the same address
		System.out.println(p1.getName()==p2.getName());//true
		System.out.println("super.clone() is a shallow copy.");

	}

}
