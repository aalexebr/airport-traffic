package org.java.spring.pojo.service;

import org.java.spring.pojo.db.Passenger;
import org.java.spring.pojo.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;
	
	public Passenger findById(int id) {
		return passengerRepo.findById(id).orElse(null);
	}
}
