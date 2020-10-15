package com.mercury.flights.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.flights.beans.Airport;
import com.mercury.flights.http.Response;
import com.mercury.flights.services.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	@PostMapping
	public Response save(@RequestBody Airport airport) {
		return airportService.save(airport);
	}
	
	@GetMapping
	public List<Airport> getAll() {
		return airportService.getAll();
	}

}
