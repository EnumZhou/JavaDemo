package com.mercury.flights.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.flights.beans.Airline;
import com.mercury.flights.http.Response;
import com.mercury.flights.services.AirlineService;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@PostMapping
	public Response save(@RequestBody Airline airline){
		return airlineService.save(airline);
	}
	
	@GetMapping
	public List<Airline> getAll() {
		return airlineService.getAll();
	}
	
	@PutMapping
	public Response update(@RequestBody Airline airline) {
		return airlineService.update(airline);
	}
	
//	@DeleteMapping
//	public Response delete(int id) {
//		return airlineService.delete(id);
//	}
	
	

}
