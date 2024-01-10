package org.java.spring.pojo.repo;

import org.java.spring.pojo.db.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
