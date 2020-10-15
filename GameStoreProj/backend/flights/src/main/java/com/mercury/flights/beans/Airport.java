package com.mercury.flights.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AIRPORT")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="AIRPORTNAME")
	private String airportName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
	
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airport(int id, String airportName, String city, String country) {
		super();
		this.id = id;
		this.airportName = airportName;
		this.city = city;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", airportName=" + airportName + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
