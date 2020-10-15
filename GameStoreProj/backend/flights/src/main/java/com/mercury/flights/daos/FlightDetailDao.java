package com.mercury.flights.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.flights.beans.FlightDetail;

public interface FlightDetailDao extends JpaRepository<FlightDetail,Integer> {

}
