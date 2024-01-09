package org.java.spring.pojo.service;

import org.java.spring.pojo.db.Flight;
import org.java.spring.pojo.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepo;
	
	public Flight findById(int id) {
		return flightRepo.findById(id).orElse(null);
	}
}
