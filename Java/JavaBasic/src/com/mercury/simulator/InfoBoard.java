package com.mercury.simulator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class InfoBoard {
	private Map<String, Flight> flights;

	private InfoBoard() {
		flights = new HashMap<String, Flight>();

	}

	private static class A {
		private final static InfoBoard ib = new InfoBoard();
	}

	public static InfoBoard getInstance() {
		return A.ib;
	}

	public void addNewFlight(Flight f) {
		flights.put(f.getId(), f);
	}

	public Flight getFlightById(String id) {
		Flight f = null;
		try {
			f = (Flight) flights.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No such flight.");
		}

		return f;
	}

	public List<Flight> getFlightsByCompanyId(String companyId) {
		List<Flight> l = new LinkedList<Flight>();
		try {
			flights.forEach((k, v) -> {
				if(companyId==v.getCompanyId())
				{
					l.add(v);
				}

			});

		} catch (Exception e) {

		}

		return l;
	}
	
	public Map<String, Flight> getFights(){
		return flights;
		
	}

}
