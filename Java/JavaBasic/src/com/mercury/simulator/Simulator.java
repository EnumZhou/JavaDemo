package com.mercury.simulator;

import java.util.Map;

public class Simulator {
	
	public void startAll(){
		InfoBoard ib=InfoBoard.getInstance();
		Map<String,Flight> flights=ib.getFights();
		flights.forEach((k,v)-> 
				   {
					    v.run();
					}
				
				);
	}
	
	public static void main(String args[]){
		InfoBoard ib=InfoBoard.getInstance();
		ib.addNewFlight(new Flight("NK 130","NK","MCO","EWR",2500));
		ib.addNewFlight(new Flight("UA 415","UA","LAX","EWR",5000));
		ib.addNewFlight(new Flight("AS 31","AS","EWR","SEA",6000));
		ib.addNewFlight(new Flight("UA 1784","UA","EWR","MCI",3000));
		ib.addNewFlight(new Flight("BA 1679","B6","BOS","EWR",1500));
		Simulator simulator=new Simulator();
		simulator.startAll();
		
		//System.out.println(ib.getFlightById("NK 13").toString());
		
	}

}
