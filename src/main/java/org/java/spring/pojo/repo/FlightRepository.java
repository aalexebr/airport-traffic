package org.java.spring.pojo.repo;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.pojo.db.Employee;
import org.java.spring.pojo.db.Flight;
import org.java.spring.pojo.db.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	@Query("SELECT f.employees FROM Flight f WHERE f.id = :flightId")
    List<Employee> findEmployeesByFlightId(@Param("flightId") int flightId);
	 
	@Query("SELECT f.passengers FROM Flight f WHERE f.id = :flightId")
    List<Passenger> findPassengersByFlightId(@Param("flightId") int flightId);

	@Query("SELECT f FROM Flight f WHERE f.departureAirport.name LIKE %:name%")
	List<Flight> searchFlightByAirportDepName(@Param("name")String name);
	
	@Query("SELECT f FROM Flight f WHERE f.departureAirport.city LIKE %:name%")
	List<Flight> searchFlightByAirportDepCity(@Param("name")String name);
	
	@Query("SELECT f FROM Flight f WHERE f.departureAirport.city LIKE %:name%")
	Page<Flight> searchFlightByAirportDepCityPaginated(Pageable pageable, @Param("name")String name);
	
	@Query("SELECT f FROM Flight f WHERE f.departure_datetime = :date")
	List<Flight> searchFlightByAirportDepDate(@Param("date")LocalDate date);
	
	@Query("SELECT f FROM Flight f WHERE f.departure_datetime = :date")
	Page<Flight> searchFlightByAirportDepDatePaginated(Pageable pageable,@Param("date")LocalDate date);
	
	@Query("SELECT f FROM Flight f WHERE f.arrival_datetime = :date")
	List<Flight> searchFlightByAirportArrivaleDate(@Param("date")LocalDate date);
	
	@Query("SELECT f FROM Flight f WHERE f.arrival_datetime = :date")
	Page<Flight> searchFlightByAirportArrDatePaginated(Pageable pageable,@Param("date")LocalDate date);
	
	@Query("SELECT f FROM Flight f WHERE f.departureAirport.city LIKE %:name% AND f.departure_datetime = :date")
	List<Flight> searchByDepCityAndDepDate(@Param("name")String name,@Param("date")LocalDate date);
}
