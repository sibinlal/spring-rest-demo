package com.test.springrest.restController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springrest.entity.Student;
import com.test.springrest.exception.StudentErrorResponse;
import com.test.springrest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> student;
	
	@PostConstruct
	public void loadData() {
		
		student = new ArrayList<Student>();
		student.add(new Student("sibin","lal"));
		student.add(new Student("UST","EFX"));		
	}
	
	// Define end point /student
	
	@GetMapping("/students")
	public List<Student> getStudents(){	
		return student;
	}
	
	// Return specific student based on id. @PathVariable
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId){		
		
		if(studentId >= student.size() || studentId < 0) {
			throw new StudentNotFoundException("StudentID not found-"+studentId);
		}
		
		return student.get(studentId);
	}
	
	// Exception handling codes moved to @ControllerAdvice class.+
	

}
