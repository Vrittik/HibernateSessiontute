package com.tute.HibernateSessiontute;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity(name="student_details")

// @Table(name="my_students")  to make entity name same but table name different, comes after entity
@Entity()
public class Student {
	
	@Id
	private int id;
	private String name;
	private String city;
	private Certificate certi;
	
	public Certificate getCerti() {
		return certi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String city, Certificate certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
}
