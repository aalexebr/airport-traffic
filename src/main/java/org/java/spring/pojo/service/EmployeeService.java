package org.java.spring.pojo.service;

import java.util.List;

import org.java.spring.pojo.db.Employee;
import org.java.spring.pojo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	public Employee findById(int id) {
		return employeeRepo.findById(id).orElse(null);
	}
	
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}
	
	public void delete(Employee employee) {
		employeeRepo.delete(employee);
	}
	
	public void deleteById(int id) {
		employeeRepo.deleteById(id);
	}
	
	
}
