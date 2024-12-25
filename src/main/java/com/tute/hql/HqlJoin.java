package com.tute.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HqlJoin {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		// After join, the first thing is the table name from which join is to happen
		// here the table name is f and after that . and then the name of the field(other entity) for join
		
		// one to many join example
		String hql = "SELECT f.facultyName, f.salary, t.traineeName FROM Faculty AS f JOIN f.trainees as t ORDER BY f.facultyName";
		Query<Object[]> query = s.createQuery(hql, Object[].class);
		
		// many to one join example
		String hql2 = "SELECT t.traineeName, f.facultyName from Trainee t JOIN t.faculty as f ORDER BY t.traineeName";
		Query<Object[]> query2 = s.createQuery(hql2, Object[].class);
		
		List<Object[]> facultyPerTrainee = query.list();
		List<Object[]> traineePerFaculty = query2.list();
		
		for(Object[] f : facultyPerTrainee) {
			System.out.println("Faculty " + (String) f[0] + " " + " is training " + (String) f[2]);
		}
		
		System.out.println("\n");
		
		for(Object[] t : traineePerFaculty) {
			System.out.println("Trainee " + (String) t[0] + " " + " is being trained by " + (String) t[1]);
		}
		
		
		s.close();
		factory.close();
	}
}
