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
@Table(name="student")
@EntityListeners(AuditingEntityListener.class)

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String first_name;
	@NotBlank
	private String last_name;
	@NotBlank 
	private String stream;
	@NotBlank
	private String location;
	public Long getIdentity() {
		return id;
	}

	public void setIdentity(Long identity) {
		this.id = identity;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getstream() {
		return stream;
	}
	public void setstream(String stream) {
		this.stream = stream;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	

}
