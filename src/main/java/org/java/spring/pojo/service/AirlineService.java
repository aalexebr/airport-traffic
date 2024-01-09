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
	
	public void save(Airline airline) {
		airlineRepo.save(airline);
	}
	
	public void delete(Airline airline) {
		airlineRepo.delete(airline);
	}
	
	public void deleteById(int id) {
		airlineRepo.deleteById(id);
	}
	
	public Airline findByName(String name) {
		return airlineRepo.findByName(name);
	}

}
