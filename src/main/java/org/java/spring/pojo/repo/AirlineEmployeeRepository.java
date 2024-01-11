package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.AirlineEmployee;
import org.java.spring.pojo.restDTO.AirlineEmployeeDTO;
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
	
//	using DTO to remove airline column
	@Query("SELECT new org.java.spring.pojo.restDTO.AirlineEmployeeDTO(p.id, p.employee, p.hiring_date, p.layoff_date) "
			+ "FROM AirlineEmployee p "
			+ "WHERE p.airline.id = :id "
			+ "ORDER BY p.id ASC")
	List<AirlineEmployeeDTO> findByAirlineIdWithDTO(@Param("id")int id);
	
	@Query("SELECT new org.java.spring.pojo.restDTO.AirlineEmployeeDTO(p.id, p.employee, p.hiring_date, p.layoff_date) "
			+ "FROM AirlineEmployee p "
			+ "WHERE p.airline.id = :id "
			+ "ORDER BY p.id ASC")
	Page<AirlineEmployeeDTO> findByAirlineIdWithDTOPaginated(Pageable pageable,@Param("id")int id);
	
	@Query("SELECT new org.java.spring.pojo.restDTO.AirlineEmployeeDTO(p.id, p.employee, p.hiring_date, p.layoff_date) "
			+ "FROM AirlineEmployee p "
			+ "WHERE p.airline.id = :id "
			+ "AND p.layoff_date IS NULL "
			+ "ORDER BY p.id ASC")
	List<AirlineEmployeeDTO> findActiveEmployeesByAirlineIdWithDTO(@Param("id")int id);
	
	@Query("SELECT new org.java.spring.pojo.restDTO.AirlineEmployeeDTO(p.id, p.employee, p.hiring_date, p.layoff_date) "
			+ "FROM AirlineEmployee p "
			+ "WHERE p.airline.id = :id "
			+ "AND p.layoff_date IS NULL "
			+ "ORDER BY p.id ASC")
	Page<AirlineEmployeeDTO> findActiveEmployeesByAirlineIdWithDTOPaginated(Pageable pageable,@Param("id")int id);
}
