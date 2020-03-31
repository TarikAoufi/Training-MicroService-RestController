package org.sid.controller;

import java.util.List;

import org.sid.entity.Student;
import org.sid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST Controller basée sur Spring MVC.
 * Permet de gérer des étudiants.
 * 
 */
@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students") 
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable(name = "id") Long id) {
		return studentRepository.getOne(id);
	}

	@PostMapping("/students")
	public Student save(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping("/students/{id}")
	public Student update(@PathVariable(name = "id") Long id, @RequestBody Student student) {
		student.setId(id);
		return studentRepository.save(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable(name="id")Long id) {
		studentRepository.deleteById(id);
	}

}
