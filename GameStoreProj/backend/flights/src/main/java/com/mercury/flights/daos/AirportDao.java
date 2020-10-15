package com.mercury.flights.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.flights.beans.Airport;

public interface AirportDao extends JpaRepository<Airport,Integer> {

}
