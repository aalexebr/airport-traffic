package org.java.spring.pojo.service;

import org.java.spring.pojo.db.MaintenanceJob;
import org.java.spring.pojo.repo.MaintenanceJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainteneceJobService {
	
	@Autowired
	private MaintenanceJobRepository MJRepo;
	
	public MaintenanceJob findById(int id) {
		return MJRepo.findById(id).orElse(null);
	}
}
