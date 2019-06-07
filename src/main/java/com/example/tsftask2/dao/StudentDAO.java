package com.example.tsftask2.dao;

import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.tsftask2.model.Student;
import com.example.tsftask2.repository.StudentRepository;

@Service
public class StudentDAO {
	
	@Autowired
	StudentRepository studentRepository;
	
	/*Insert an student */
	public Student save( Student std) {
		return studentRepository.save(std);
	}
	/*To find all students */
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	/*Retrieve an Student by id*/
	public Student findOne(Long studid) {
		return studentRepository.findById(studid).orElse(null);
		
	}
	
	/*Delete an student */
	public void delete(Student stud) {
		studentRepository.delete(stud);
		
	}


}
