package org.java.spring.pojo.service;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.repo.AirlineEmployeeRepository;
import org.java.spring.pojo.restDTO.AirlineEmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AirlineEmployeeService {

	@Autowired
	private AirlineEmployeeRepository AERepo;
	
//	AIRLINE SIDE
	
	public List<AirlineEmployee> findByAirlineId(int id){
		return AERepo.findByAirlineId(id);
	}
	
	public List<AirlineEmployeeDTO> findByArlineIdWithDTO(int id){
		return AERepo.findByAirlineIdWithDTO(id);
	}
	
	public Page<AirlineEmployee> findAllEmployeesByAirlineIdPaginated(Pageable pageable, int id){
		return AERepo.findByAirlineIdPaginated(pageable, id);
	}
	
	public List<AirlineEmployee> findCurrentEmployeesByAirlineId(int id){
		return AERepo.findCurrentEmployeesByAirlineId(id);
	}
	
//	EMPLOYEE SIDE
	
	public List<AirlineEmployee> findByEmployeeId(int id){
		return AERepo.findByEmployeeId(id);
	}
	
//	this one sucks needs specific query
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
