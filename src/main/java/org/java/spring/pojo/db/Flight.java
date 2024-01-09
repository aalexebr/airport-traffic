package org.java.spring.pojo.db;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String number;
	
	private LocalDate departure_datetime;
	
	private LocalDate arrival_datetime;
	
	@ManyToOne
	private Airplane airplane;
	
	@ManyToOne
	private Airline airline;
	
	@ManyToOne
    @JoinColumn(name = "departure_airport_id")
	@JsonProperty
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    @JsonProperty
    private Airport arrivalAirport;
	
	public Flight() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getDeparture_datetime() {
		return departure_datetime;
	}

	public void setDeparture_datetime(LocalDate departure_datetime) {
		this.departure_datetime = departure_datetime;
	}

	public LocalDate getArrival_datetime() {
		return arrival_datetime;
	}

	public void setArrival_datetime(LocalDate arrival_datetime) {
		this.arrival_datetime = arrival_datetime;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	
	

}