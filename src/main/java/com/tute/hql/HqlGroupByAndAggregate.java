package com.tute.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tute.hql.Feeders.Faculty;

public class HqlGroupByAndAggregate {

	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		// Group by
		String hql = "SELECT d.departmentName, COUNT(f) FROM Faculty f JOIN f.departments as d GROUP BY d.departmentName";
		
		// Aggregate function
		String hqlAvg = "SELECT AVG(salary) from Faculty";
		String hqlMax = "SELECT MAX(salary) from Faculty";
		String hqlMin = "SELECT min(salary) from Faculty";
		String hqlSum = "SELECT sum(salary) from Faculty";
		
		// this below is wrong, in count we need to pass alias
		//String hqlCount = "SELECT COUNT(Faculty) from Faculty";
		String hqlCount = "SELECT COUNT(f) from Faculty f";
		
		// Faculty with only one department
		String hqlUniqueFaculty = "SELECT DISTINCT f from Faculty f JOIN f.departments";
		
		Query<Object[]> query = s.createQuery(hql, Object[].class);
		
		// Double is a class type for primitive type double
		// Cannot use primitive types in query type safety provision
		Query<Double> query2 = s.createQuery(hqlAvg, Double.class);
		Query<Integer> query3 = s.createQuery(hqlMax, Integer.class);
		Query<Integer> query4 = s.createQuery(hqlMin, Integer.class);
		Query<Long> query5 = s.createQuery(hqlSum, Long.class);
		Query<Long> query6 = s.createQuery(hqlCount, Long.class);
		Query<Faculty> query7 = s.createQuery(hqlUniqueFaculty, Faculty.class);
		
		
		
		
		// To get the single result use getSingleResult, getFirstResult returns the starting
		// index of the result in case of pagination
		// set through query.setFirstResult(10), getFirstResult will return 10
		
		double avgRes = query2.getSingleResult();
		Integer maxRes = query3.getSingleResult();
		Integer minRes = query4.getSingleResult();
		Long sumRes = query5.getSingleResult();
		Long countRes = query6.getSingleResult();
		List<Faculty> uniqueFacultyRes = query7.list();
		
		List<Object[]> res = query.list();
		
		for(Object[] obj: res)
		{
			System.out.println((String) obj[0] + " has " + (long) obj[1] + " faculties \n");
		}
		
		String aggregateRes = String.
				format("Average value of salary = %.3f, max salary = %d, min salary = %d, sum of salaries = %d, total faculties = %d \n", 
						avgRes,
						maxRes,
						minRes, 
						sumRes, 
						countRes);
		
		System.out.println(aggregateRes);
		
		System.out.println("Faculties with unique department \n");
		for(Faculty f: uniqueFacultyRes) {
			System.out.print(f.getFacultyName() + " ");
		}
		
		s.close();
		factory.close();
	}
}
