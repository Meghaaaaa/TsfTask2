package com.example.tsftask2.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="book")
@EntityListeners(AuditingEntityListener.class)

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String book_name;
	@NotBlank
	private String author;
	@NotBlank 
	private String publication;
	
	@NotBlank
	private String type;
	
	public Long getIdentity() {
		return id;
	}

	public void setIdentity(Long identity) {
		this.id = identity;
	}
	
	public String getbook_name() {
		return book_name;
	}
	public void setbook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getauthor() {
		return author;
	}
	public void setauthor(String author) {
		this.author = author;
	}
	public String getpublication() {
		return publication;
	}
	public void setpublication(String publication) {
		this.publication = publication;
	}
	
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	

}
