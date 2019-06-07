package com.example.tsftask2.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tsftask2.dao.StudentDAO;
import com.example.tsftask2.model.Student;

@RestController
@RequestMapping("/institute")
public class StudentController {
	@Autowired
	StudentDAO studentDAO;
	
	/* to save an student */
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student std) {
		return studentDAO.save(std);
	}
	/*to get all students*/
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentDAO.findAll();
	}
	/*to get student by studid */
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studid){
		
		Student std = studentDAO.findOne(studid);
		
		if(std==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(std);
	}
	
	
	/*update an student by studid*/
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long studid,@Valid @RequestBody Student studDetails){
		
		Student std = studentDAO.findOne(studid);
		if(std==null) {
			return ResponseEntity.notFound().build();
		}
		std.setFirst_name(studDetails.getFirst_name());
		std.setLast_name(studDetails.getLast_name());
		std.setstream(studDetails.getstream());
		std.setlocation(studDetails.getlocation());
		
		Student updateStudent=studentDAO.save(std);
		return ResponseEntity.ok().body(updateStudent);
	}
	
	/* To delete an Student */
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long studid){
		Student std = studentDAO.findOne(studid);
		if(std==null) {
			return ResponseEntity.notFound().build();
		}
		studentDAO.delete(std);
		
		return ResponseEntity.ok().build();
		
	}

}
