package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.db.Airline;
import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.db.Airplane;
import org.java.spring.pojo.db.Employee;
import org.java.spring.pojo.db.Flight;
import org.java.spring.pojo.service.AirlineEmployeeService;
import org.java.spring.pojo.service.AirlineService;
import org.java.spring.pojo.service.AirplaneService;
import org.java.spring.pojo.service.EmployeeService;
import org.java.spring.pojo.service.FlightService;
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
	
	@Autowired
	AirplaneService airplaneServ;
	
	@Autowired
	FlightService flightService;

	@GetMapping("airline_employee")
	public ResponseEntity<List<AirlineEmployee>> getPivot(){
		
		List<AirlineEmployee> n = AEService.findCurrent(1);
		
		return new ResponseEntity<>(n, HttpStatus.OK);
	}
	
	@GetMapping("airline-employee-history")
	public ResponseEntity<List<AirlineEmployee>> getHistory(){
		
		List<AirlineEmployee> n = AEService.findByEmployeeId(1);
		
		return new ResponseEntity<>(n, HttpStatus.OK);
	}
	
	@GetMapping("airline")
	public ResponseEntity<Airline> getAirline(){
		
		Airline a = airlineServ.findById(2);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("employee")
	public ResponseEntity<Employee> getEmployee(){
		
		Employee a = empServ.findById(2);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("airplane")
	public ResponseEntity<Airplane> getAirplane(){
		
		Airplane a = airplaneServ.findById(1);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("flight")
	public ResponseEntity<Flight> getFlight(){
		
		Flight a = flightService.findById(1);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
}
