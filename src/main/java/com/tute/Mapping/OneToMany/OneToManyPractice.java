package com.tute.Mapping.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToManyPractice {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");  // can use without params if config file present in resources
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	// Defined Tata motors
    	TataMotors tataSohnaRoad = new TataMotors();
    	tataSohnaRoad.setAddress("Sohna road");
    	tataSohnaRoad.setContactNumber("9988776767");
    	//
    	
    	// Defined vehicles
    	Vehicle safari = new Vehicle();
    	safari.setVehicleModel("Top model");
    	safari.setVehicleName("Safari");
    	safari.setTataMotors(tataSohnaRoad);
    	
    	Vehicle harrier = new Vehicle();
    	harrier.setVehicleModel("Base model");
    	harrier.setVehicleName("Harrier");
    	harrier.setTataMotors(tataSohnaRoad);
    	//
    	
    	List<Vehicle> vehiclesTataSohnaRoad = new ArrayList<Vehicle>();
    	vehiclesTataSohnaRoad.add(harrier);
    	vehiclesTataSohnaRoad.add(safari);
    	
    	tataSohnaRoad.setVehicles(vehiclesTataSohnaRoad);
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.persist(safari);
    	session.persist(harrier);
    	session.persist(tataSohnaRoad);
    	
    	tx.commit();
    	
    	
    	// retrieve
    	TataMotors motors = session.find(TataMotors.class, 1);
    	
    	System.out.println("Tata Motors in " + motors.getAddress() + ", Call us at " + motors.getContactNumber());
    	
    	System.out.println("Has vehicles");
    	for(Vehicle v: motors.getVehicles())
    	{
    		System.out.println(v.getVehicleName() + " with " + v.getVehicleModel());
    	}
    	
    	session.close();
    	factory.close();
	}
}
