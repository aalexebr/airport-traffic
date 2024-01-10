package org.java.spring.pojo.db;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "airline_employee")
public class AirlineEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    private LocalDate hiring_date;
    
    private LocalDate layoff_date;
    
    public AirlineEmployee() {}

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
