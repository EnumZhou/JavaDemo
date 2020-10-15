package com.mercury.flights.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="FLIGHTDETAIL")
public class FlightDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="FLIGHTID")
	private String flightId;
	
	@Column(name="DEPART")
	private String depart;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    
	@Column(name="DEPTDATE")
	private Date deptDate;
	
	@Column(name="ARRIVAL")
	private String arrival;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	@Column(name="ARRDATE")
	private Date arrDate;
	
	@Column (name="STOPNO")
	private int stopNo;

	public FlightDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDetail(int id, String flightId, String depart, Date deptDate, String arrival, Date arrDate,
			int stopNo) {
		super();
		this.id = id;
		this.flightId = flightId;
		this.depart = depart;
		this.deptDate = deptDate;
		this.arrival = arrival;
		this.arrDate = arrDate;
		this.stopNo = stopNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Date getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(Date deptDate) {
		this.deptDate = deptDate;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public Date getArrDate() {
		return arrDate;
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public int getStopNo() {
		return stopNo;
	}

	public void setStopNo(int stopNo) {
		this.stopNo = stopNo;
	}

	@Override
	public String toString() {
		return "FlightDetail [id=" + id + ", flightId=" + flightId + ", depart=" + depart + ", deptDate=" + deptDate
				+ ", arrival=" + arrival + ", arrDate=" + arrDate + ", stopNo=" + stopNo + "]";
	}
	
}
