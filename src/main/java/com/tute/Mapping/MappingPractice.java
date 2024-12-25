package com.tute.Mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingPractice {
	
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration();
    	cfg.configure("hibernate.cfg.xml");  // can use without params if config file present in resources
    	
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Answer ans1 = new Answer();
//        ans1.setAnswerId(1);
        ans1.setAnswer("Java is a programming language");
        
        Answer ans2 = new Answer();
//        ans2.setAnswerId(2);
        ans2.setAnswer("Python is interpretor language");
        
        Question q1 = new Question();
        
        Question q2 = new Question();
        
        q1.setQuestion("What is java?");
//        q1.setQuestionId(1);
        q1.setAnswer(ans1);
        
        q2.setQuestion("Python is compiler or interpretor language?");
        q2.setAnswer(ans2);
        
        
        // Bi direction
        ans1.setQuestion(q1);
        ans2.setQuestion(q2);
        
        Transaction tx = session.beginTransaction();
       
        session.persist(q1);
        session.persist(q2);
        
        session.persist(ans1);
        session.persist(ans2);
        
        
        tx.commit();
                
        Question q1Db = session.find(Question.class, 1);
        Question q2Db = session.find(Question.class, 2);
        
        
        Answer ans1Db = session.find(Answer.class, 1);
        Answer ans2Db = session.find(Answer.class, 2);
        
        System.out.println(q1Db.getQuestion() + " Ans =  " + q1Db.getAnswer().getAnswer());
        System.out.println(q2Db.getQuestion() + " Ans =  " + q2Db.getAnswer().getAnswer());
        
        System.out.println(ans1Db.getAnswer() + " Quest =  " + ans1Db.getQuestion().getQuestion());
        System.out.println(ans2Db.getAnswer() + " Quest =  " + ans2Db.getQuestion().getQuestion());
        
        factory.close();
        
	}
}
