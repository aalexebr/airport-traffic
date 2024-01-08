package org.java.spring.pojo.service;

import java.util.List;

import org.java.spring.pojo.db.Airline;
import org.java.spring.pojo.repo.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {
	
	@Autowired 
	private AirlineRepository airlineRepo;
	
	public List<Airline> findAll(){
		return airlineRepo.findAll();
	}
	
	public Airline findById(int id) {
		return airlineRepo.findById(id).orElse(null);
	}

}
