package com.mercury.flights.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.flights.beans.Airline;

public interface AirlineDao extends JpaRepository<Airline,Integer> {
	
}
