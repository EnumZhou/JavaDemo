package com.mercury.flights.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.flights.beans.FlightDetail;
import com.mercury.flights.daos.FlightDetailDao;
import com.mercury.flights.http.Response;

@Service
public class FlightDetailService {

	@Autowired
	private FlightDetailDao flightDetailDao;

	public Response save(FlightDetail flightDetail) {
		try {
//			String arr1=flightDetail.getArrDate();
//			flightDetail.setArrDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(flightDetail.getArrDate()));
//			flightDetail.setDeptDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2012-04-23 18:25:43.51"));

			flightDetailDao.save(flightDetail);
			return new Response(true);
		} catch (Exception e) {
			return new Response(false);
		}
	}

	public List<FlightDetail> getAll() {
		return flightDetailDao.findAll();
	}

}
