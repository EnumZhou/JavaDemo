package com.mercury.pokergame;

import java.util.LinkedList;

public class Player implements Runnable{
	private String name;
	private LinkedList<Card> cards;
	public Player(String name,LinkedList<Card>cards){
		this.name=name;
		this.cards=cards;
	}
	
	public String getName(){return name;}
	public LinkedList<Card> getCards(){return cards;}
	
	@Override
	synchronized public void run(){
		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
