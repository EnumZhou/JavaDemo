package com.mercury.flights.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.flights.beans.Flight;

public interface FlightDao extends JpaRepository<Flight,Integer>{

}
