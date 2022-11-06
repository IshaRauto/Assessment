package com.spring.repo;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.model.Student;
public interface StudentRepository extends MongoRepository<Student,Integer>{

	Optional<Student> findById(String id);

	void deleteById(String id);
 
	
}
