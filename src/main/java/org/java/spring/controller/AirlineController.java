package org.java.spring.controller;

import org.java.spring.pojo.db.Airline;
import org.java.spring.pojo.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirlineController {

	@Autowired
	AirlineService airlineSevice;
	
	@GetMapping("findbyid/{id}")
	public ResponseEntity<Airline> findById(Model model, @PathVariable int id){
		Airline x = airlineSevice.findById(id);
		
		if(x == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
}
