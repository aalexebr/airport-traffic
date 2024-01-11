package org.java.spring.pojo.restDTO;

import java.time.LocalDate;

import org.java.spring.pojo.db.Employee;

public class AirlineEmployeeDTO {
	
	private Integer id;
    private Employee employee;
    private LocalDate hiring_date;
    private LocalDate layoff_date;
    
    public AirlineEmployeeDTO() {}
    
    public AirlineEmployeeDTO(Integer id,Employee employee, LocalDate hiring_date,LocalDate layoff_date) {
    	setId(id);
    	setEmployee(employee);
    	setHiring_date(hiring_date);
    	setLayoff_date(layoff_date);
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
