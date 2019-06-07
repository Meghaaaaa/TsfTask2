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

import com.example.tsftask2.dao.EmployeeDAO;
import com.example.tsftask2.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	EmployeeDAO EmployeeDAO;
	
	/* to save an Employee */
	@PostMapping("/Employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return EmployeeDAO.save(emp);
	}
	/*to get all Employees*/
	@GetMapping("/Employees")
	public List<Employee> getAllEmployee(){
		return EmployeeDAO.findAll();
	}
	/*to get Employee by empid */
	
	@GetMapping("/Employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp = EmployeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	
	/*update an Employee by empid*/
	
	@PutMapping("/Employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp = EmployeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setDesignation(empDetails.getDesignation());
		emp.setFirst_name(empDetails.getFirst_name());
		emp.setLast_name(empDetails.getLast_name());
		emp.setlocation(empDetails.getlocation());
		emp.setprojectname(empDetails.getprojectname());
		
		Employee updateEmployee=EmployeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	/* To delete an Employee */
	@DeleteMapping("/Employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		Employee emp = EmployeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		EmployeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
	}

}
