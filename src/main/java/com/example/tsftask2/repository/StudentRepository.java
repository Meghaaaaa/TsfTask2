package com.example.tsftask2.repository;
import com.example.tsftask2.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}


