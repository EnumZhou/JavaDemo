package com.mercury.flights.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.flights.beans.Airport;
import com.mercury.flights.daos.AirportDao;
import com.mercury.flights.http.Response;

@Service
public class AirportService {
	@Autowired
	private AirportDao airportDao;
	
	public Response save (Airport airport){
		try {
			airportDao.save(airport);
			return new Response(true);
		}catch(Exception e){
			return new Response(false);
		}
		
	}
	
	public List<Airport> getAll(){
		return airportDao.findAll();
	}
	
	
}
