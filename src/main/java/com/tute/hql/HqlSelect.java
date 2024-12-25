package com.tute.hql;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tute.hql.Feeders.Faculty;


public class HqlSelect {

	public static void main(String[] args)
	{

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		String hql = "From Faculty";
		Query<Faculty> query = s.createQuery(hql, Faculty.class);
		List<Faculty> faculties = query.list();
		
		String hql2 = "SELECT f.facultyName, f.joiningDate from Faculty as f";
		Query<Object[]> query2 = s.createQuery(hql2, Object[].class); // provide class as its type safe
		
		List<Object[]> results = query2.list(); //class with pvt members are collection of primitive type objects
		s.close();
		
		for(Faculty faculty: faculties)
		{
			System.out.println(faculty.getFacultyName() + " Joined in " + faculty.getJoiningDate());
		}
		
		System.out.println("__________________________________________________ \n");
		for(Object[] row: results)
		{
			LocalDate joiningDate = (LocalDate) row[1];
			String facultyName = (String) row[0];
			System.out.println(facultyName + " joined in " + joiningDate);
		}
		
		
		factory.close();
	}
}
