package org.java.spring.pojo.service;

import java.util.List;

import org.java.spring.pojo.db.Employee;
import org.java.spring.pojo.db.Flight;
import org.java.spring.pojo.db.Passenger;
import org.java.spring.pojo.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepo;
	
	public Flight findById(int id) {
		return flightRepo.findById(id).orElse(null);
	}
	
	public List<Employee> getFlightEmployees(int id){
		return flightRepo.findEmployeesByFlightId(id);
	}
	
	public List<Passenger> getFlightPassengers(int id){
		return flightRepo.findPassengersByFlightId(id);
	}
	
	// FLIGHT QUERIES
	
	public List<Flight> findFlightsByDepAirportCity(String city){
		return flightRepo.searchFlightByAirportDepCity(city);
	}
	
	public Page<Flight> findFlightsByDepAirportCity(Pageable page, String city){
		return flightRepo.searchFlightByAirportDepCityPaginated(page,city);
	}
}
