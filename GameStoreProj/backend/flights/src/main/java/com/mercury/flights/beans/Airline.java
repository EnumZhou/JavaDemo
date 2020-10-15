package com.mercury.flights.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AIRLINE")
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="AIRLINENAME")
	private String airlineName;

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airline(int id, String airlineName) {
		super();
		this.id = id;
		this.airlineName = airlineName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Override
	public String toString() {
		return "airline [id=" + id + ", airlineName=" + airlineName + "]";
	}
}
