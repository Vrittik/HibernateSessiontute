package com.tute.Mapping.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyPractice {

	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Employee e1 = new Employee();
		e1.setEmployeeId(100);
		e1.setEmployeeAge("45");
		e1.setEmployeeName("Arun");
		
		Employee e2 = new Employee();
		e2.setEmployeeId(101);
		e2.setEmployeeAge("24");
		e2.setEmployeeName("Vrittik");
	
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setProjectId(204);
		p1.setProjectDuration("2 Months");
		p1.setProjectName("Java backend");
		
		p2.setProjectId(205);
		p2.setProjectDuration("1 month");
		p2.setProjectName("Java core");
		
		
		List<Project> projectsForEmp1 = new ArrayList<>();
		List<Project> projectsForEmp2 = new ArrayList<>();
		
		List<Employee> empsForProj1 = new ArrayList<>();
		List<Employee> empsForProj2 = new ArrayList<>();
		
		projectsForEmp1.add(p2);
		projectsForEmp1.add(p1);
		
		projectsForEmp2.add(p2);
		
		empsForProj1.add(e1);
		empsForProj1.add(e2);
		
		empsForProj2.add(e1);
		
		e1.setProjects(projectsForEmp1);
		e2.setProjects(projectsForEmp2);
		
		p1.setEmployees(empsForProj1);
		p2.setEmployees(empsForProj2);
		
		Transaction tx = session.beginTransaction();
		
//		session.persist(e2);
//		session.persist(e1);
//		
//		session.persist(p1);
//		session.persist(p2);
////		
		tx.commit();
		
		
		// Lazy and eager loading
		
		Employee emp = session.find(Employee.class, 100);
		
		
		// When lazy loaded, uncomment this to get the project lazily loaded
//		for(Project p: emp.getProjects())
//		{
//			
//		}
		session.close();
		factory.close();
	}
}
