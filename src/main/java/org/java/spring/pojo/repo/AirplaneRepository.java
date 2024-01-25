package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.Airplane;
import org.java.spring.pojo.db.MaintenanceJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer>{
	
}
