package org.java.spring.pojo.repo;

import java.util.List;

import org.java.spring.pojo.db.PassengerDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDocumentRepository extends JpaRepository<PassengerDocument, Integer>{
	
	List<PassengerDocument> findByPassengerId(int id);

}
