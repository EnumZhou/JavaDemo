package com.mercury.flights.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.flights.beans.FlightDetail;
import com.mercury.flights.http.Response;
import com.mercury.flights.services.FlightDetailService;

@RestController
@RequestMapping("/flightDetails")
public class FlightDetailController {
	
	@Autowired
	private FlightDetailService flightDetailService;
	
	@PostMapping
	public Response save(@RequestBody FlightDetail flightDetail) {
		return flightDetailService.save(flightDetail);
	}
	
	@GetMapping
	public List<FlightDetail> getAll() {
		return flightDetailService.getAll();
	}

}
