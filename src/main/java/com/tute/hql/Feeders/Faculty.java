package com.tute.hql.Feeders;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String facultyName;
	
	@ManyToMany
	@JoinTable
	(
			name = "faculty_by_department",
			joinColumns = @JoinColumn(name="facultyId"),
			inverseJoinColumns = @JoinColumn(name="departmentId")
	)
	private List<Department> departments;
	
	@OneToMany(mappedBy = "faculty")
	private List<Trainee> trainees;
	
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	public List<Trainee> getTrainees() {
		return trainees;
	}
	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private LocalDate joiningDate;
	private int salary;
}
