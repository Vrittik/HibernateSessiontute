package com.tute.HibernateSessiontute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddTute {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");  // can use without params if config file present in resources
    	
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student std1 = new Student();
        
        std1.setId(1);
        std1.setCity("Gurgaon");
        std1.setName("Vaibhav");
        
        Certificate certi1 = new Certificate();
        certi1.setCourse("Hibernate");
        certi1.setDuration("10 hours");
        
        std1.setCerti(certi1);
        
        Student std2 = new Student();
        
        std2.setId(2);
        std2.setCity("Gurgaon");
        std2.setName("Vrittik");
        
        Certificate certi2 = new Certificate();
        certi2.setCourse("Spring data jpa");
        certi2.setDuration("11 hours");
        
        std2.setCerti(certi2);
        
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.persist(std1);
        session.persist(std2);
        
        tx.commit();
        session.close();
        factory.close();
	}
}
