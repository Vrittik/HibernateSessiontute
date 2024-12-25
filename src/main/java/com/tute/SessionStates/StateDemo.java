package com.tute.SessionStates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		// Transient state - not associated with session or db
		Worker worker = new Worker();
		worker.setworkerAge("14");
		worker.setworkerName("Test Worker");
		worker.setId(123);
		// Transient state - not associated with session or db
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		// Persistent state, saved in db and associated with the session
		s.persist(worker);
		
		//getting data in persistent state
		Worker workerGet = s.find(Worker.class, 123);
		System.out.println(workerGet.getworkerName());
		
		//updating data in persistent state
		//Update keeps context of the object state and updates it in the db
		//As the persist has already been called, the object is associated and sync
		//is happening so no need to call persist again
		worker.setworkerName("Ramesh");
		
		//getting updated data in persistent state
		workerGet = s.find(Worker.class, 123);
		System.out.println(workerGet.getworkerName());
		
		tx.commit();
		
		s.close();
		
		// detached state
		worker.setworkerName("Sachin");
		
		
		factory.close();
	}
}
