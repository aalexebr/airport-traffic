package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.MaintenanceJob;
import org.java.spring.pojo.restDTO.AirplaneMaintenanceJobDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceJobRepository extends JpaRepository<MaintenanceJob, Integer>{

	@Query("SELECT new org.java.spring.pojo.restDTO.AirplaneMaintenanceJobDTO(p.id, p.dateTime, p.title, p.description) "
			+ "FROM MaintenanceJob p "
			+ "WHERE p.airplane.id = :id "
			+ "ORDER BY p.id ASC")
	List<AirplaneMaintenanceJobDTO> findByAirplaneId(@Param("id")int id);
}
