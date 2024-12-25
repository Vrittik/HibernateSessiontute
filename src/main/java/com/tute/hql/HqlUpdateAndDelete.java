package com.tute.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.tute.hql.Feeders.Faculty;


public class HqlUpdateAndDelete {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		String hql = "UPDATE Faculty f SET f.salary = f.salary + :newSalary where f.facultyName = :facultyName";
	    MutationQuery query = s.createMutationQuery(hql);
	    query.setParameter("newSalary", 10000);
	    query.setParameter("facultyName", "Mr Ashwani");
	    
	    Transaction tx = s.beginTransaction();
	    
	    query.executeUpdate();
	    
	    tx.commit();
	    
	    String hql2 = "FROM Faculty where facultyName = :facultyName";
	    Query<Faculty> query2 = s.createQuery(hql2, Faculty.class);
	    query2.setParameter("facultyName", "Mr Ashwani");
	    Faculty f = (Faculty) query2.getSingleResult();
	    
	    // another way
	    Faculty f2 = s.find(Faculty.class, 3);
	    
	    System.out.println("Mr Ashwani now drawing : " + f.getSalary());
	    System.out.println("----------------------------------------\n");
	    System.out.println("Mr Ashwani now drawing : " + f.getSalary());
	    
		s.close();
		factory.close();
		
	}
}
