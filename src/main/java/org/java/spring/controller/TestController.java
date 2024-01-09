package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.db.Airline;
import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.db.Employee;
import org.java.spring.pojo.service.AirlineEmployeeService;
import org.java.spring.pojo.service.AirlineService;
import org.java.spring.pojo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	EmployeeService empServ;
	
	@Autowired
	AirlineService airlineServ;
	
	@Autowired
	AirlineEmployeeService AEService;

	@GetMapping
	public ResponseEntity<List<AirlineEmployee>> getTest(){
		
		Airline a = new Airline("xxx","testAiline");
		
		Employee x = empServ.findById(1);
		
		List<AirlineEmployee> n = AEService.findByEmployeeId(1);
		
		return new ResponseEntity<>(n, HttpStatus.OK);
	}
}
