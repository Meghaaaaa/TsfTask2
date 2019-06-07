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

import com.example.tsftask2.model.Book;
import com.example.tsftask2.repository.BookRepository;

@Service
public class BookDAO {
	
	@Autowired
	BookRepository BookRepository;
	
	/*Insert an Book */
	public Book save( Book b) {
		return BookRepository.save(b);
	}
	/*To find all Books */
	public List<Book> findAll(){
		return BookRepository.findAll();
	}
	
	/*Retrieve an Books by id*/
	public Book findOne(Long bid) {
		return BookRepository.findById(bid).orElse(null);
		
	}
	
	/*Delete an student */
	public void delete(Book b) {
		BookRepository.delete(b);
		
	}


}
