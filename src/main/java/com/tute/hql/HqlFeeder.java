package com.tute.hql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tute.hql.Feeders.*;

public class HqlFeeder {

	public static void main(String[] args)
	{
		// Department
		Department science = new Department();
		science.setDepartmentHod("Mr Ashok");
		science.setDepartmentName("Science department");
		
		Department maths = new Department();
		maths.setDepartmentHod("Mr Sushil");
		maths.setDepartmentName("Maths department");
		
		Department commerce = new Department();
		commerce.setDepartmentHod("Mr Anurag");
		commerce.setDepartmentName("Commerce department");
		
		Department arts = new Department();
		arts.setDepartmentHod("Mr Vijay");
		arts.setDepartmentName("Arts department");
		
		Department economics = new Department();
		economics.setDepartmentHod("Mr Arun");
		economics.setDepartmentName("economics department");
		// End department
		
		// Faculty
		Faculty facultyMath1 = new Faculty();
		facultyMath1.setFacultyName("Mr Kuldeep");
		facultyMath1.setJoiningDate(LocalDate.of(2012, 4, 12));
		facultyMath1.setSalary(40000);
		
		Faculty facultyMath2 = new Faculty();
		facultyMath2.setFacultyName("Mr Ashwani");
		facultyMath2.setJoiningDate(LocalDate.of(2011, 6, 23));
		facultyMath2.setSalary(45000);
		
		Faculty facultyScience1 = new Faculty();
		facultyScience1.setFacultyName("Mr RudraPratap");
		facultyScience1.setJoiningDate(LocalDate.of(2007, 1, 14));
		facultyScience1.setSalary(50000);
		
		Faculty facultyCommerce1 = new Faculty();
		facultyCommerce1.setFacultyName("Mr Hirdesh");
		facultyCommerce1.setJoiningDate(LocalDate.of(2011, 11, 9));
		facultyCommerce1.setSalary(20000);
		
		Faculty facultyCommerce2 = new Faculty();
		facultyCommerce2.setFacultyName("Mrs Neha");
		facultyCommerce2.setJoiningDate(LocalDate.of(2010, 5, 5));
		facultyCommerce2.setSalary(22000);
		
		Faculty facultyArts1 = new Faculty();
		facultyArts1.setFacultyName("Mrs Roshni");
		facultyArts1.setJoiningDate(LocalDate.of(2012, 4, 12));
		facultyArts1.setSalary(11000);
		
		Faculty facultyArts2 = new Faculty();
		facultyArts2.setFacultyName("Mr Manmohan");
		facultyArts2.setJoiningDate(LocalDate.of(2012, 6, 27));
		facultyArts1.setSalary(13000);
		// End Faculty
		
		// Trainee
		Trainee ts1 = new Trainee();
		ts1.setTraineeAge("23");
		ts1.setTraineeName("trainee 1");
		
		Trainee ts2= new Trainee();
		ts2.setTraineeAge("24");
		ts2.setTraineeName("trainee 2");
		
		Trainee tm1 = new Trainee();
		tm1.setTraineeAge("28");
		tm1.setTraineeName("trainee 3");
		
		Trainee tm2 = new Trainee();
		tm2.setTraineeAge("25");
		tm2.setTraineeName("trainee 4");
		
		Trainee tc1 = new Trainee();
		tc1.setTraineeAge("28");
		tc1.setTraineeName("trainee 5");
		
		Trainee tc2 = new Trainee();
		tc2.setTraineeAge("27");
		tc2.setTraineeName("trainee 6");
		
		Trainee tc3 = new Trainee();
		tc3.setTraineeAge("27");
		tc3.setTraineeName("trainee c3");
		
		Trainee tc4 = new Trainee();
		tc4.setTraineeAge("27");
		tc4.setTraineeName("trainee c4");
		
		
		Trainee ta1 = new Trainee();
		ta1.setTraineeAge("20");
		ta1.setTraineeName("trainee 7");
		
		Trainee ta2 = new Trainee();
		ta2.setTraineeAge("21");
		ta2.setTraineeName("trainee 9");
		// End Trainee
		
		// Cross relations faculty trainee
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(tm1);
		facultyMath1.setTrainees(trainees);
		tm1.setFaculty(facultyMath1);
		
		trainees = new ArrayList<Trainee>();
		trainees.add(tm2);
		trainees.add(tc1);
		facultyMath2.setTrainees(trainees);
		tm2.setFaculty(facultyMath2);
		tc1.setFaculty(facultyMath2);
		
		trainees = new ArrayList<Trainee>();
		trainees.add(ts1);
		trainees.add(ts2);
		facultyScience1.setTrainees(trainees);
		ts1.setFaculty(facultyScience1);
		ts2.setFaculty(facultyScience1);
		
		trainees = new ArrayList<Trainee>();
		trainees.add(tc2);
		trainees.add(tc3);
		facultyCommerce2.setTrainees(trainees);
		tc2.setFaculty(facultyCommerce2);
		tc3.setFaculty(facultyCommerce2);
		
		trainees = new ArrayList<Trainee>();
		trainees.add(tc4);
		facultyCommerce1.setTrainees(trainees);
		tc4.setFaculty(facultyCommerce1);
		
		trainees = new ArrayList<Trainee>();
		trainees.add(ta1);
		facultyArts1.setTrainees(trainees);
		ta1.setFaculty(facultyArts1);
		
		
		trainees = new ArrayList<Trainee>();
		trainees.add(ta2);
		facultyArts2.setTrainees(trainees);
		ta2.setFaculty(facultyArts2);
		// End cross relations faculty trainee
		
		
		// Cross relation faculty department
		List<Faculty> faculties = new ArrayList<>();
		faculties.add(facultyScience1);
		faculties.add(facultyMath1);
		faculties.add(facultyMath2);
		science.setFaculties(faculties);
		
		faculties = new ArrayList<>();
		faculties.add(facultyCommerce1);
		faculties.add(facultyCommerce2);
		faculties.add(facultyMath1);
		faculties.add(facultyMath2);
		commerce.setFaculties(faculties);
		
		faculties = new ArrayList<>();
		faculties.add(facultyMath1);
		faculties.add(facultyMath2);
		maths.setFaculties(faculties);
		
		faculties = new ArrayList<>();
		faculties.add(facultyArts2);
		faculties.add(facultyArts1);
		arts.setFaculties(faculties);
		
		faculties = new ArrayList<>();
		faculties.add(facultyArts1);
		faculties.add(facultyArts2);
		economics.setFaculties(faculties);
		
		facultyScience1.setDepartments(new ArrayList<>());
		facultyMath1.setDepartments(new ArrayList<>());
		facultyMath2.setDepartments(new ArrayList<>());
		facultyCommerce1.setDepartments(new ArrayList<>());
		facultyCommerce2.setDepartments(new ArrayList<>());
		facultyArts1.setDepartments(new ArrayList<>());
		facultyArts2.setDepartments(new ArrayList<>());
		
		List<Department> departments = new ArrayList<>();
		departments.add(economics);
		departments.add(science);
		departments.add(commerce);
		departments.add(arts);
		departments.add(maths);
		
		for(Department department: departments)
		{
			for(Faculty faculty : department.getFaculties())
			{
				List<Department> d = faculty.getDepartments();
				d.add(department);
				faculty.setDepartments(d);
			}
		}
		// End cross relations faculty department
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		// Department
		s.persist(maths);
		s.persist(commerce);
		s.persist(economics);
		s.persist(arts);
		s.persist(science);
		
		
		// Faculty
		s.persist(facultyScience1);
		s.persist(facultyMath1);
		s.persist(facultyMath2);
		s.persist(facultyCommerce1);
		s.persist(facultyCommerce2);
		s.persist(facultyArts1);
		s.persist(facultyArts2);
		
		// Trainee
		s.persist(tc4);
		s.persist(tc1);
		s.persist(tc2);
		s.persist(tc3);
		s.persist(ts1);
		s.persist(ts2);
		s.persist(tm1);
		s.persist(tm2);
		s.persist(ta1);
		s.persist(ta2);
		
		tx.commit();
		
		s.close();
		factory.close();
		
	}
}
