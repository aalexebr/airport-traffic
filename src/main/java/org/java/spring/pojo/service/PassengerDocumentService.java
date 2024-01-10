package org.java.spring.pojo.service;

import java.util.List;

import org.java.spring.pojo.db.PassengerDocument;
import org.java.spring.pojo.repo.PassengerDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerDocumentService {

	@Autowired
	private PassengerDocumentRepository passDocRepo;
	
	public List<PassengerDocument> findDocumentsOfPassengerById(int id){
		return passDocRepo.findByPassengerId(id);
	}
}
