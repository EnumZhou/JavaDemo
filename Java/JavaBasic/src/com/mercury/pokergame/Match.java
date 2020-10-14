package com.mercury.pokergame;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

final class Match {
	private int id = 0;
	private List<Player> players = new LinkedList<Player>();

	private Match() {
		id += 1;
		LinkedList<Card> cardPool = cardsPool();
		Player p1 = new Player("P1", dealCards(cardPool));
		Player p2 = new Player("P2", dealCards(cardPool));
		Player p3 = new Player("P3", dealCards(cardPool));
		Player p4 = new Player("P4", dealCards(cardPool));
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		Instant start =Instant.now();
		startMatch(players);
		Instant end =Instant.now();
		System.out.println(start);
		System.out.println(end);
		

	}

	private LinkedList<Card> dealCards(LinkedList<Card> cardPool) {
		LinkedList<Card> cards = new LinkedList<Card>();
		Random r = new Random();
		for (int i = 0; i < 13; i++) {
			int index = r.nextInt(cardPool.size());
			Card c = cardPool.get(index);
			cards.add(c);
			cardPool.remove(c);
		}
		return cards;
	}

	private final static Match m = new Match();

	public static Match getInstance() {
		return m;
	}
	
	private void startMatch(List<Player> players)
	{
			Player p1=players.get(0);
			Player p2=players.get(1);
			Player p3=players.get(2);
			Player p4=players.get(3);
			for(int j=0;j<p1.getCards().size();j++){
				p1.run();
				p2.run();
				p3.run();
				p4.run();
			}
	}

	public void getMatchInfo() {
		for (int i = 0; i < players.size(); i++) {
			String name = players.get(i).getName();
			LinkedList<Card> cards = players.get(i).getCards();
			System.out.println(name);
			for (int j = 0; j < cards.size(); j++) {
				System.out.println(cards.get(j).getSuit() + " , " + cards.get(j).getRank());
			}
		}
	}

	public void cardPoolInfor() {
		LinkedList<Card> cardPool = cardsPool();
		for (int i = 0; i < cardPool.size(); i++) {
			System.out.println(cardPool.get(i).getSuit() + " , " + cardPool.get(i).getRank());
		}
	}

	private LinkedList<Card> cardsPool() {
		// create card pool that have 52 cards
		LinkedList<Card> cardPool = new LinkedList<Card>();
		List<String> rankList = new LinkedList<String>();
		rankList.add("2");
		rankList.add("3");
		rankList.add("4");
		rankList.add("5");
		rankList.add("6");
		rankList.add("7");
		rankList.add("8");
		rankList.add("9");
		rankList.add("10");
		rankList.add("J");
		rankList.add("Q");
		rankList.add("K");
		rankList.add("A");
		for (int i = 0; i < 13; i++) {
			Card spadeCard = new Card("Spade", rankList.get(i));
			Card HeartCard = new Card("Heart", rankList.get(i));
			Card ClubCard = new Card("Club", rankList.get(i));
			Card DiamondCard = new Card("Diamond", rankList.get(i));
			cardPool.add(spadeCard);
			cardPool.add(HeartCard);
			cardPool.add(ClubCard);
			cardPool.add(DiamondCard);
		}
		return cardPool;
	}

	public static void main(String[] args) {
		// Scanner input=new Scanner(System.in);
		// System.out.println("Input first player' name: ");
		// String p1=input.next();
		// System.out.println("Input second player' name: ");
		// String p2=input.next();
		// System.out.println("Input third player' name: ");
		// String p3=input.next();
		// System.out.println("Input fourth player' name: ");
		// String p4=input.next();

		Match match = Match.getInstance();
		// match.cardPoolInfor();
		match.getMatchInfo();

	}

}
