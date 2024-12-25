package com.tute.Mapping.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vehicleName;
	private String vehicleModel;
	@ManyToOne   //Many vehicles mapped to one tata motors
	private TataMotors tataMotors;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public TataMotors getTataMotors() {
		return tataMotors;
	}

	public void setTataMotors(TataMotors tataMotors) {
		this.tataMotors = tataMotors;
	}
	
}
