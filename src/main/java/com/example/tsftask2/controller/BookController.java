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

import com.example.tsftask2.dao.BookDAO;
import com.example.tsftask2.model.Book;

@RestController
@RequestMapping("/Library")
public class BookController {
	@Autowired
	BookDAO BookDAO;
	
	/* to save an Book */
	@PostMapping("/Books")
	public Book createBook(@Valid @RequestBody Book b) {
		return BookDAO.save(b);
	}
	/*to get all Books*/
	@GetMapping("/Books")
	public List<Book> getAllBooks(){
		return BookDAO.findAll();
	}
	/*to get book by bdid */
	
	@GetMapping("/Books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(value="id") Long bid){
		
		Book b = BookDAO.findOne(bid);
		
		if(b==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(b);
	}
	
	
	/*update an book by bid*/
	
	@PutMapping("/Books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value="id") Long bid,@Valid @RequestBody Book BookDetails){
		
		Book b = BookDAO.findOne(bid);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}
		b.setbook_name(BookDetails.getbook_name());
		b.setauthor(BookDetails.getauthor());
		b.setpublication(BookDetails.getpublication());
		b.settype(BookDetails.gettype());
		
		Book updateBook=BookDAO.save(b);
		return ResponseEntity.ok().body(updateBook);
	}
	
	/* To delete a Book */
	@DeleteMapping("/Books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable(value="id") Long bid){
		Book b = BookDAO.findOne(bid);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}
		BookDAO.delete(b);
		
		return ResponseEntity.ok().build();
		
	}

}
