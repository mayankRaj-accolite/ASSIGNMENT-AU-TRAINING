package com.accolite.JUnitAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// getting data from the data base
		List<StudentDetails> studentList = new ArrayList<StudentDetails>();

		Criteria cr = session.createCriteria(StudentDetails.class);
		cr.add(Restrictions.gt("id", 0));
		studentList = cr.list();

		System.out.println("\nStudent Data from Database: \n");

		for (StudentDetails s : studentList) {
			System.out.print("StudentID: " + s.getId());
			System.out.print("   Marks: " + s.getPercentage());
			System.out.print("   DOB: " + s.getDob());
			System.out.println("   StudentName: " + s.getName());
			
		}
		System.out.println("\n");
		

		StudentService st = new StudentService();
		List<Ranking> rankList= st.getRankList(studentList);
//		
//		  for (Ranking rank : rankList) 
//		  { 
//			  session.save(rank);
//		  }
//		  session.getTransaction().commit();
//		
//		  
		 
		  System.out.println("\n\nStudent Rank: \n");
		  for (Ranking s : rankList) {
			    System.out.print("Rank: "+s.getStudentRank());
			    System.out.print("   Marks: " + s.getPercentage());
				System.out.print("   DOB: " + s.getDob());
				System.out.print("   StudentID: " + s.getId());
				System.out.println("   StudentName: " + s.getName());
				
			}
		  
		  

		

	}
}
