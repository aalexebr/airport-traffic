package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.db.Airline;
import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.db.Airplane;
import org.java.spring.pojo.db.Employee;
import org.java.spring.pojo.db.Flight;
import org.java.spring.pojo.db.Passenger;
import org.java.spring.pojo.db.PassengerDocument;
import org.java.spring.pojo.service.AirlineEmployeeService;
import org.java.spring.pojo.service.AirlineService;
import org.java.spring.pojo.service.AirplaneService;
import org.java.spring.pojo.service.EmployeeService;
import org.java.spring.pojo.service.FlightService;
import org.java.spring.pojo.service.PassengerDocumentService;
import org.java.spring.pojo.service.PassengerService;
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
	
	@Autowired 
	PassengerService passengerServ;
	
	@Autowired
	PassengerDocumentService passDocService;

	@GetMapping("airline_employee")
	public ResponseEntity<List<AirlineEmployee>> getCurrentAirlineforEmployeeId(){
		
		List<AirlineEmployee> n = AEService.findCurrent(1);
		
		return new ResponseEntity<>(n, HttpStatus.OK);
	}
	
	@GetMapping("airline-employee-history")
	public ResponseEntity<List<AirlineEmployee>> getHistoryofAirlinesForEmployeeId(){
		
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
	
	@GetMapping("flight-employees")
	public ResponseEntity<List<Employee>> getFlightEmployees(){
		
		List<Employee> a = flightService.getFlightEmployees(1);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("passenger")
	public ResponseEntity<Passenger> getPassenger(){
		
		Passenger a = passengerServ.findById(2);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("flight-passengers")
	public ResponseEntity<List<Passenger>> getFlightPassengers(){
		
		List<Passenger> a = flightService.getFlightPassengers(1);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("passenger-document")
	public ResponseEntity<List<PassengerDocument>> getPassemgerDocument(){
		
		List<PassengerDocument> a = passDocService.findDocumentsOfPassengerById(2);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
}
