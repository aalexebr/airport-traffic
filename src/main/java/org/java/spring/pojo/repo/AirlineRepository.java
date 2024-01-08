package org.java.spring.pojo.repo;

import org.java.spring.pojo.db.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer>{

}
