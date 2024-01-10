package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.AirlineEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineEmployeeRepository extends JpaRepository<AirlineEmployee, Integer>{
	@Query("SELECT p FROM AirlineEmployee p WHERE p.employee.id = :id")
	List<AirlineEmployee> findByEmployeeId(@Param("id")int id);
	
	@Query("SELECT p FROM AirlineEmployee p WHERE p.airline.id = :id")
	List<AirlineEmployee> findByAirlineId(@Param("id")int id);
	
	@Query("SELECT p FROM AirlineEmployee p WHERE p.airline.id = :id")
	Page<AirlineEmployee> findByAirlineIdPaginated(Pageable pageable,@Param("id")int id);
	
	@Query("SELECT p FROM AirlineEmployee p WHERE p.airline.id = :id AND p.layoff_date IS NULL ")
	List<AirlineEmployee> findCurrentEmployeesByAirlineId(@Param("id") int id);
}
