package com.mercury.flights.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FLIGHT")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="FLIGHTNO")
	private String flightNo;
	
	@Column(name="AIRLINE")
	private String airline;
	
	@Column(name="SEATS")
	private int seats;
	
	@Column(name="IMAGE")
	private String image;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(int id, String flightNo, String airline, int seats, String image) {
		super();
		this.id = id;
		this.flightNo = flightNo;
		this.airline = airline;
		this.seats = seats;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNo=" + flightNo + ", airline=" + airline + ", seats=" + seats + ", image="
				+ image + "]";
	}
	
}
