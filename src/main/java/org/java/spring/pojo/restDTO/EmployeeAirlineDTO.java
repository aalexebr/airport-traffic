package org.java.spring.pojo.restDTO;

import java.time.LocalDate;

import org.java.spring.pojo.db.Airline;

public class EmployeeAirlineDTO {
	
	private Integer id;
	private Airline airline;
	private LocalDate hiring_date;
    private LocalDate layoff_date;
    
    public EmployeeAirlineDTO(Integer id,Airline airline,LocalDate hiring_date,LocalDate layoff_date) {
    	setId(id);
    	setAirline(airline);
    	setHiring_date(hiring_date);
    	setLayoff_date(layoff_date);
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public LocalDate getHiring_date() {
		return hiring_date;
	}
	public void setHiring_date(LocalDate hiring_date) {
		this.hiring_date = hiring_date;
	}
	public LocalDate getLayoff_date() {
		return layoff_date;
	}
	public void setLayoff_date(LocalDate layoff_date) {
		this.layoff_date = layoff_date;
	}
    
    

}
