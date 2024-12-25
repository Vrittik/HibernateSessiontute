package com.tute.Mapping.OneToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TataMotors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String contactNumber;
	
	@OneToMany(mappedBy = "tataMotors") // Reduce table creation to store relationship
	private List<Vehicle> vehicles;     // Only vehicle will store the foreign key of tatamotors
	 									// fetch action can also be performed from tata motors class though
										// to get the vehicle list
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public TataMotors() {
		super();
		// TODO Auto-generated constructor stub
	}
}
