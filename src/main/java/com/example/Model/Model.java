package com.example.Model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Model 
{
	@Id
	int id;
	String firstName;
	String lastName;
	String college;
	@CreatedDate
	LocalDate date=LocalDate.now();
	public LocalDate getDate() {
		return date;
	}
	public int getId() {
		return id;
	}
	public Model(int id, String firstName, String lastName, String college,LocalDate date) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.college = college;
		this.date=LocalDate.now();
	}
	public Model() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
}

