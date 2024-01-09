package org.java.spring.controller;

import org.java.spring.pojo.db.Airline;
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

	@GetMapping
	public ResponseEntity<Airline> getTest(){
		
		Airline a = new Airline("xxx","testAiline");
		
		airlineServ.save(a);
		
		Airline x = airlineServ.findByName("testAiline");
		
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
}
