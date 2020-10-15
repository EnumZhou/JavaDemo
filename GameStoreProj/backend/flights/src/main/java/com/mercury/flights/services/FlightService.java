package com.mercury.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.flights.beans.Flight;
import com.mercury.flights.daos.FlightDao;
import com.mercury.flights.http.Response;

@Service
public class FlightService {
	@Autowired
	private FlightDao flightDao;
	
	public Response save (Flight flight) {
		try {
			flightDao.save(flight);
			return new Response(true);
		}
		catch (Exception e){
			return new Response(false);
		}
		
	}
	
	public List<Flight> getAll(){
		return flightDao.findAll();
	}
}
