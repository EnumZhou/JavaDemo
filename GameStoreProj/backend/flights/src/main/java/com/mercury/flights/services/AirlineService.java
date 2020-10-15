package com.mercury.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.flights.beans.Airline;
import com.mercury.flights.daos.AirlineDao;
import com.mercury.flights.http.Response;

@Service
public class AirlineService {
	@Autowired
	private AirlineDao airlineDao;
	
	public Response save(Airline airline){
		try
		{
			airlineDao.save(airline);
			return new Response(true);
		}
		catch (Exception e) 
		{
			return new Response(false);
		}
	}
	
	public List<Airline> getAll() {
		return airlineDao.findAll();
	}
	
	public Response update (Airline airline) {
		try {
			Airline al = airlineDao.findById(airline.getId()).get();
			al.setAirlineName(airline.getAirlineName());
			airlineDao.save(al);
			return new Response(true);
		}catch (Exception e) {
			return new Response (false);
		}
	}
	
	
}
