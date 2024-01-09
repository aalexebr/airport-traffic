package org.java.spring.pojo.repo;

import org.java.spring.pojo.db.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer>{
	
}
