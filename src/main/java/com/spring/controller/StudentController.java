package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.excep.ResourceNotFoundException;
import com.spring.model.Student;
import com.spring.repo.StudentRepository;

@CrossOrigin(origins = "http://localhost:3000")

@RestController

public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		Student save=this.studentRepository.save(student);
		
		return ResponseEntity.ok(save);
	}
	
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents()
	{
		
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
	

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable String id) {
		Student bus_info = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		return ResponseEntity.ok(bus_info);
	}
	
	@PutMapping("/student/{id}")
	
	public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student){
		Student stud = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
		stud.setS_id(student.getS_id());
		stud.setName(student.getName());
		stud.setLanguage(student.getLanguage());
		stud.setFramework(student.getFramework());
		
		
		Student updateStudentDetail = studentRepository.save(stud);
		return ResponseEntity.ok(updateStudentDetail);
	} 
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable String id) {
		studentRepository.deleteById(id);
		return "Deleted Successfully";
		
	}
	
}
