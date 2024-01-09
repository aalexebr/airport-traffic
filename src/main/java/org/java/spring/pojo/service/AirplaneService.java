package org.java.spring.pojo.service;

import org.java.spring.pojo.db.Airplane;
import org.java.spring.pojo.repo.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneService {

	@Autowired
	private AirplaneRepository airplaneRepo;
	
	public Airplane findById(int id) {
		return airplaneRepo.findById(id).orElse(null);
	}
}
