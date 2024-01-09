package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.AirlineEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineEmployeeRepository extends JpaRepository<AirlineEmployee, Integer>{
	List<AirlineEmployee> findByEmployeeId(int id);
}
