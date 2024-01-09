package org.java.spring.pojo.db;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airplanes")
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String manufacturer;
	
	private String model;
	
	private Long seating_capacity;
	
	@OneToMany(mappedBy="airplane")
	@JsonIgnore
	private List<Flight> flights;
	
	public Airplane() {}
	public Airplane(String manufacturer,String model, Long seating_capacity) {
		setManufacturer(manufacturer);
		setModel(model);
		setSeating_capacity(seating_capacity);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getSeating_capacity() {
		return seating_capacity;
	}

	public void setSeating_capacity(Long seating_capacity) {
		this.seating_capacity = seating_capacity;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
}
