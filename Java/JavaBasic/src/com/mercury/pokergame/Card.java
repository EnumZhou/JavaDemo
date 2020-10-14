package com.mercury.pokergame;

import java.util.List;

public class Card {
	private String suit;
	private String rank;
	
	public Card(String suit, String rank) {
		this.suit=suit;
		this.rank=rank;
		// TODO Auto-generated constructor stub
	}

	public String getSuit(){
		return suit;
	}
	
	public String getRank(){
		return rank;
	}
	
	@Override
	public String toString(){
		return "Suit: "+suit+" Rank: "+ rank;
	}

}
