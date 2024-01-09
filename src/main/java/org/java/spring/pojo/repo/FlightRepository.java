package org.java.spring.pojo.repo;

import org.java.spring.pojo.db.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
