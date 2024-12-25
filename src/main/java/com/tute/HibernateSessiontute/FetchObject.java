package com.tute.HibernateSessiontute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchObject {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student std = session.find(Student.class, 102);  // use load, find() method to get data
		Address add = session.find(Address.class, 1);
		Address add2 = session.find(Address.class, 1); // query only run once as data is cached in session
	
		
//		try {
//		   Student std3 =(Student)session.load(Student.class, 102);
//		}
//		catch(ObjectNotFoundException ex)
//		{
//			
//		}
		
		System.out.println(std.getCity() + " " + std.getName());
		System.out.print(add.getCity() + " " + add.getStreet());
		
				
		session.close();
		factory.close();
	}

}
