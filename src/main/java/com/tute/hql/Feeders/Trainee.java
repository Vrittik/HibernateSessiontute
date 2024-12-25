package com.tute.hql.Feeders;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String traineeName;
	
	@ManyToOne
	@JoinTable
	(
			name="trainee_by_faculty",
			joinColumns = {@JoinColumn(name="TraineeId")}, 
			inverseJoinColumns = {@JoinColumn(name="FacultyId")}
	) // The main join column is the mapped by column, which is traineeId here and inverse
	// columns is facultyId
	private Faculty faculty;
	
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeAge() {
		return traineeAge;
	}
	public void setTraineeAge(String traineeAge) {
		this.traineeAge = traineeAge;
	}
	private String traineeAge;
}
