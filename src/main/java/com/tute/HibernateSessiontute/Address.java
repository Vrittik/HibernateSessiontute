package com.tute.HibernateSessiontute;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	
	@Column(name="STREET", length=50)
	private String street;
	
	@Column(name="CITY", length=100)
	private String city;
	
	@Column(name="is_open")
	private boolean isOpen;
	
	@Transient // column will not create
	private double x;
	
	@Column(name="added_date")
	private LocalDate addedData;
	
	@Lob // image is a large object
	private byte[] image;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public LocalDate getAddedData() {
		return addedData;
	}
	public void setAddedData(LocalDate addedData) {
		this.addedData = addedData;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Address(int addressId, String street, String city, boolean isOpen, double x, LocalDate addedData, byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedData = addedData;
		this.image = image;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
}
