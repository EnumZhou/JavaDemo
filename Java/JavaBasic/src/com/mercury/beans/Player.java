package com.mercury.beans;

public class Player implements Cloneable{
	//non-static field is always private
	private int num;
	private String name;
	private String team;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(int num, String name, String team) {
		super();
		this.num = num;
		this.name = name;
		this.team = team;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	
	@Override
	public Player clone() {
		//shallow Copy
		//return new Player(this.num,this.name,this.team);
		//deep copy
		//return new Player(this.num,new String(name),new String("team"));
		Player p=null;
		try {
			//super.clone() actually copy the player object so that it can downcast
			p= (Player)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public String toString() {
		return "Player [num=" + num + ", name=" + name + ", team=" + team + "]";
	}

	
	
	
	

}
