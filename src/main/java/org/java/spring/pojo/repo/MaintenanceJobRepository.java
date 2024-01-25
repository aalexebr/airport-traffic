package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.MaintenanceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceJobRepository extends JpaRepository<MaintenanceJob, Integer>{

	List<MaintenanceJob> findByAirplaneId(int id);
}
