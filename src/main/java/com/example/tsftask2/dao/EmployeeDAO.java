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

import com.example.tsftask2.model.Employee;
import com.example.tsftask2.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository EmployeeRepository;
	
	/*Insert an student */
	public Employee save( Employee emp) {
		return EmployeeRepository.save(emp);
	}
	/*To find all students */
	public List<Employee> findAll(){
		return EmployeeRepository.findAll();
	}
	
	/*Retrieve an Student by id*/
	public Employee findOne(Long empid) {
		return EmployeeRepository.findById(empid).orElse(null);
		
	}
	
	/*Delete an student */
	public void delete(Employee emp) {
		EmployeeRepository.delete(emp);
		
	}


}
