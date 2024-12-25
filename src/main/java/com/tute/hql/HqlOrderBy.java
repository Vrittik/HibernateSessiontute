package com.tute.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tute.hql.Feeders.Faculty;

public class HqlOrderBy {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		String hql = "SELECT f from Faculty f ORDER BY f.salary DESC";
		
		// named query
		Query<Faculty> q1 = s.createQuery(hql, Faculty.class);
		Query<Faculty> q2 = s.createNativeQuery("SELECT * from Faculty ORDER BY salary DESC", Faculty.class);
		// Not passing List<Faculty> as result class because we have to pass the value which
		// will the result of the individual rows of this query
		
		List<Faculty> faculties1 = q1.list();
		
		List<Faculty> faculties2 = q2.getResultList(); // use getResultList for executing native sql query
		s.close();
		
		for(var faculty: faculties1)
		{
			System.out.println(faculty.getFacultyName() + " " + faculty.getSalary());
		}
		
		System.out.println("----------------------------------------------\n");
				
		for(var faculty: faculties2)
		{
			System.out.println(faculty.getFacultyName() + " " + faculty.getSalary());
		}
		
		factory.close();
		
	}
}
