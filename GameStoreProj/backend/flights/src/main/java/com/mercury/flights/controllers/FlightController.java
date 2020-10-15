package com.mercury.flights.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.flights.beans.Flight;
import com.mercury.flights.http.Response;
import com.mercury.flights.services.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping
	public Response save(@RequestBody Flight flight) {
		return flightService.save(flight);
	}
	
	@GetMapping
	public List<Flight> getAll() {
		return flightService.getAll();
	}

}
