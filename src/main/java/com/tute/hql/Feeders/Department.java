package com.tute.hql.Feeders;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String departmentName;
	private String departmentHod;
	
	@ManyToMany(mappedBy = "departments")
	private List<Faculty> faculties;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Faculty> getFaculties() {
		return faculties;
	}
	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentHod() {
		return departmentHod;
	}
	public void setDepartmentHod(String departmentHod) {
		this.departmentHod = departmentHod;
	}
}
