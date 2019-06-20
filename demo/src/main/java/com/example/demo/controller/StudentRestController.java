package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepository repository;

	@GetMapping("/students")
	public List<Student> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getOneById(@PathVariable("id") Integer id) {
		return repository.getOne(id);
	}
	
	@PostMapping
	public void saveStudent(@RequestBody Student student) {
		repository.save(student);
	}
	
	@PutMapping("/students/{id}")
	public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		
	}

}
