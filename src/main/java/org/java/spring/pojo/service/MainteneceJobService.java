package org.java.spring.pojo.service;

import java.util.List;

import org.java.spring.pojo.db.MaintenanceJob;
import org.java.spring.pojo.repo.MaintenanceJobRepository;
import org.java.spring.pojo.restDTO.AirplaneMaintenanceJobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainteneceJobService {
	
	@Autowired
	private MaintenanceJobRepository MJRepo;
	
	public MaintenanceJob findById(int id) {
		return MJRepo.findById(id).orElse(null);
	}
	
	public List<AirplaneMaintenanceJobDTO> getMJByAirplaneId(int id){
		return MJRepo.findByAirplaneId(id);
	}
}
