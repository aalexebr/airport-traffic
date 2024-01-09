package org.java.spring.pojo.service;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.repo.AirlineEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineEmployeeService {

	@Autowired
	private AirlineEmployeeRepository AERepo;
	
	public List<AirlineEmployee> findByEmployeeId(int id){
		return AERepo.findByEmployeeId(id);
	}
	
	public List<AirlineEmployee> findCurrent(int id) {
		List<AirlineEmployee> x = AERepo.findByEmployeeId(id);
		
		List<AirlineEmployee> n = new ArrayList<AirlineEmployee>();
		
		for(AirlineEmployee e :x ) {
			if(e.getLayoff_date() == null) {
				n.add(e);
				return n;
			}
		}
		return x;
	}
}
