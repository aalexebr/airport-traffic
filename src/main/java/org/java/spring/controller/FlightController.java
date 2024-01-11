package org.java.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.pojo.db.Flight;
import org.java.spring.pojo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping("search-id/{id}")
	public ResponseEntity<Flight> getFlight(@PathVariable int id){
		
		Flight a = flightService.findById(id);
		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
//	@GetMapping("search-by-date")
//	public ResponseEntity<List<Flight>> searchFlights(
//			@RequestParam(required = false) LocalDate departureDate,
//			@RequestParam(required = false) LocalDate arrivalDate,
//			@RequestParam(required = false) String departureAirport,
//			@RequestParam(required = false) String arrivalAirport){
//		return new ResponseEntity<>(a, HttpStatus.OK);
//
//	}
	
	@GetMapping("city")
	public ResponseEntity<List<Flight>> flightByDepCity(){
		List<Flight> a = flightService.findFlightsByDepAirportCity("rossie");
		return new ResponseEntity<>(a, HttpStatus.OK);
		
	}
	
	@GetMapping("city-page")
	public ResponseEntity<Page<Flight>> flightByDepCityPaginated(@RequestParam(defaultValue = "0") int page){
		
		Pageable pageable = PageRequest.of(page, 3); 
		
		Page<Flight> a = flightService.findFlightsByDepAirportCity(pageable,"rossie");
		return new ResponseEntity<>(a, HttpStatus.OK);
		
	}
	
	@GetMapping("datetest")
	public ResponseEntity<List<Flight>> tets(){
		LocalDate date = LocalDate.of(2016,05,30);
		List<Flight> x = flightService.findFlightsByDepDate(date);


		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("departure-date/{date}")
	public ResponseEntity<List<Flight>> tets(@PathVariable String date){
		LocalDate dateX = LocalDate.parse(date);
		List<Flight> x = flightService.findFlightsByDepDate(dateX);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("search-dep-city-date")
	public ResponseEntity<List<Flight>> searchDepCityDate(@RequestParam String date,@RequestParam String city){
		LocalDate d = LocalDate.parse(date);
		List<Flight> x = flightService.searchByCityAndDepDate(city,d);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	

}
