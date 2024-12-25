package com.tute.SessionStates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="worker_state_demo")
public class Worker {

	@Id
	private int id;
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "worker [id=" + id + ", workerName=" + workerName + ", workerAge=" + workerAge + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getworkerName() {
		return workerName;
	}
	public void setworkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getworkerAge() {
		return workerAge;
	}
	public void setworkerAge(String workerAge) {
		this.workerAge = workerAge;
	}
	private String workerName;
	private String workerAge;
	
}
