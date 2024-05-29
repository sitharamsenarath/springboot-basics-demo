package com.springboot.springbootdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Sithara", "Senarath");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Sithara","Senarath"));
		students.add(new Student("Sithara2","Senarath2"));
		students.add(new Student("Sithara3","Senarath3"));
		
		return students;
	}
	
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(
			@PathVariable("firstName") String firstName, 
			@PathVariable("lastName")String lastName) {
		return new Student(firstName, lastName);
	}
	
	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name = "firstName") String firstName, 
			@RequestParam(name = "lastName")String lastName) {
		return new Student(firstName, lastName);
	}
}
