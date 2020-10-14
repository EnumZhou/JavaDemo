package com.mercury.simulator;

public final class Flight implements Runnable{

	private final String id;
	private final String companyId;
	private final String from;
	private final String to;
	private final int duration;
	public Flight(String id, String companyId, String from, String to, int duration) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.from = from;
		this.to = to;
		this.duration = duration;
	}
	public String getId() {
		return id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public int getDuration() {
		return duration;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", companyId=" + companyId + ", from=" + from + ", to=" + to + ", duration="
				+ duration + "]";
	}
	
	
	@Override
	synchronized public void run(){
		try{
			System.out.println("Flight "+id+ " depature from: "+from);
			Thread.sleep(duration);
			System.out.println("Flight "+id+" Arrival to: "+to);
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	
	
}
