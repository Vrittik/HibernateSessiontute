package com.tute.Mapping.ManyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int projectId;
	
	private String projectName;
	
	private String projectDuration;
	
	@ManyToMany
	@JoinTable
	(
			name="ProjectsByEmployees", 
			joinColumns = {@JoinColumn(name="EmployeeId")}, 
			inverseJoinColumns = {@JoinColumn(name="ProjectId")}
	)  
	// use to change the name of the join table, use to change the main join column
	// name and inverse join column age
	private List<Employee> employees;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
}
