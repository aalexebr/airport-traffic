package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.db.Airline;
import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.restDTO.AirlineEmployeeDTO;
import org.java.spring.pojo.service.AirlineEmployeeService;
import org.java.spring.pojo.service.AirlineService;
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
@RequestMapping("/api/airline")
public class AirlineController {

	@Autowired
	AirlineService airlineSevice;
	
	@Autowired
	AirlineEmployeeService airlineEmployeeService;
	
	@GetMapping("info/{id}")
	public ResponseEntity<Airline> findById(@PathVariable int id){
		Airline x = airlineSevice.findById(id);
		
		if(x == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("airline-employees-history/{id}")
	public ResponseEntity<List<AirlineEmployee>> getEmployeesByAirlineId(@PathVariable int id){
		List<AirlineEmployee> x = airlineEmployeeService.findByAirlineId(id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
//	deprecated
//	@GetMapping("airline-employees/{id}")
//	public ResponseEntity<List<AirlineEmployee>> getCurrentEmployeesByAirlineId(@PathVariable int id){
//		List<AirlineEmployee> x = airlineEmployeeService.findCurrentEmployeesByAirlineId(id);
//		return new ResponseEntity<>(x, HttpStatus.OK);
//	}
	
	@GetMapping("airline-employees-paginated/{id}")
	public ResponseEntity<Page<AirlineEmployee>> getCurrentEmployeesByAirlineIdPaginated(@RequestParam(defaultValue = "0") int page,
			@PathVariable int id){
		 Pageable pageable = PageRequest.of(page, 3); 
		 Page<AirlineEmployee> x = airlineEmployeeService.findAllEmployeesByAirlineIdPaginated(pageable,id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("airline-employees-all/{id}")
	public ResponseEntity<List<AirlineEmployeeDTO>> getEmployeesByAirlineIdWithDTO(@PathVariable int id){
		List<AirlineEmployeeDTO> x = airlineEmployeeService.findByArlineIdWithDTO(id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("airline-employees-all-paginated/{id}")
	public ResponseEntity<Page<AirlineEmployeeDTO>> getEmployeesByAirlineIdWithDTOPaginated(
			@RequestParam(defaultValue = "0") int page,
			@PathVariable int id){
		Pageable pageable = PageRequest.of(page, 10); 
		Page<AirlineEmployeeDTO> x = airlineEmployeeService.findByArlineIdWithDTOPaginated(pageable,id);
		
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("airline-employees-active/{id}")
	public ResponseEntity<List<AirlineEmployeeDTO>> getActiveEmployeesByAirlineIdWithDTO(@PathVariable int id){
		List<AirlineEmployeeDTO> x = airlineEmployeeService.findActiveEmployeesByAirlineIdWithDTO(id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
	
	@GetMapping("airline-employees-active-paginated/{id}")
	public ResponseEntity<Page<AirlineEmployeeDTO>> getActiveEmployeesByAirlineIdWithDTOPaginated(
			@RequestParam(defaultValue = "0") int page,
			@PathVariable int id){
		Pageable pageable = PageRequest.of(page, 10); 
		Page<AirlineEmployeeDTO> x = airlineEmployeeService.findActiveEmployeesByAirlineIdWithDTOPaginated(pageable,id);
		return new ResponseEntity<>(x, HttpStatus.OK);
	}
}
