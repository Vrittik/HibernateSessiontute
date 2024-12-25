package com.tute.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tute.hql.Feeders.Faculty;

public class HqlWhere {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		String hql = "SELECT f from Faculty f where f.salary > 20000";
		Query<Faculty> query = s.createQuery(hql, Faculty.class);
		
		String hql2 = "SELECT f from Faculty f where f.salary >= :salary";
		Query<Faculty> query2 = s.createQuery(hql2, Faculty.class);
		query2.setParameter("salary", 40000); // parameter in quotes and value next
		
//		query.setMaxResults(1); // limit 1 constraint
//		Faculty faculty = (Faculty) query.uniqueResult();
//		Faculty faculty = (Faculty) query.getSingleResult();
		
		List<Faculty> faculties = query.list();
		List<Faculty> faculties2 = query2.list();
		s.close();
		
		System.out.println("Below faculties drawing salary > 20000");
		for(var faculty: faculties)
		{
			System.out.println(faculty.getFacultyName() + " with salary of " + faculty.getSalary());
		}
		
		System.out.println("\nBelow faculties drawing salary >= 40000");
		
		for(var faculty: faculties2)
		{
			System.out.println(faculty.getFacultyName() + " with salary of " + faculty.getSalary());
		}
//		System.out.println("Top faculty with salary > 20000 " + faculty.getFacultyName() + " with salary " + faculty.getSalary());
		factory.close();
	}
}
