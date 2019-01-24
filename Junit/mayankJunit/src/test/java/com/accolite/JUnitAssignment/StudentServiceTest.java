package com.accolite.JUnitAssignment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class StudentServiceTest {
	public StudentService service;
	
	public StudentDao dmock;
	
	
	@Before
	public void setup() {
		service=new StudentService();
		dmock = Mockito.mock(StudentDao.class);
		service.setDaoVariable(dmock);
	}
	
	@Test
	public void testRanking() {
		
		
		List<StudentDetails> students=new  ArrayList<StudentDetails>();
		
		students.add(new StudentDetails());
		students.get(0).setStudentName("mayank");;
		students.get(0).setMarks(78);
		students.get(0).setDob("31-1-1998");
		students.get(0).setStudentId(1);
		
		students.add(new StudentDetails());
		students.get(1).setStudentName("Rocky");;
		students.get(1).setMarks(88);
		students.get(1).setDob("23-07-1997");
		students.get(1).setStudentId(2);
		
		students.add(new StudentDetails());
		students.get(2).setStudentName("Raunika");;
		students.get(2).setMarks(75);
		students.get(2).setDob("08-09-1996");
		students.get(2).setStudentId(3);
		
		students.add(new StudentDetails());
		students.get(3).setStudentName("Nisha");;
		students.get(3).setMarks(83);
		students.get(3).setDob("14-08-1998");
		students.get(3).setStudentId(4);
		
		students.add(new StudentDetails());
		students.get(4).setStudentName("Akash");;
		students.get(4).setMarks(68);
		students.get(4).setDob("23-06-1997");
		students.get(4).setStudentId(5);
		
		
		
		Mockito.when(dmock.getStudents()).thenReturn(students);
		
		List<Ranking> ranking=service.getRankList(students);
		
		assertEquals(5,ranking.size());
		assertEquals("Rocky",ranking.get(0).getName());
		assertEquals("Nisha",ranking.get(1).getName());
		assertEquals("mayank",ranking.get(2).getName());
		assertEquals("Raunika",ranking.get(3).getName());
		assertEquals("Akash",ranking.get(4).getName());
		
		
	}
	
	@Test
	public void testRankingEqualMarks() {
		List<StudentDetails> students=new  ArrayList<StudentDetails>();
		students.add(new StudentDetails());
		students.get(0).setStudentName("mayank");;
		students.get(0).setMarks(76);
		students.get(0).setDob("11-11-1998");
		students.get(0).setStudentId(1);
		
		students.add(new StudentDetails());
		students.get(1).setStudentName("raj");;
		students.get(1).setMarks(76);
		students.get(1).setDob("11-10-1998");
		students.get(1).setStudentId(2);
		
		students.add(new StudentDetails());
		students.get(2).setStudentName("himesh");;
		students.get(2).setMarks(69);
		students.get(2).setDob("05-08-1995");
		students.get(2).setStudentId(3);
		
		students.add(new StudentDetails());
		students.get(3).setStudentName("avinav");;
		students.get(3).setMarks(79);
		students.get(3).setDob("11-02-1997");
		students.get(3).setStudentId(4);
		
		students.add(new StudentDetails());
		students.get(4).setStudentName("akriti");;
		students.get(4).setMarks(59);
		students.get(4).setDob("10-02-1995");
		students.get(4).setStudentId(5);
		
		
		
		Mockito.when(dmock.getStudents()).thenReturn(students);
		
		List<Ranking> ranking=service.getRankList(students);
		
		assertEquals(5,ranking.size());
		assertEquals(1,ranking.get(0).getStudentRank());
		assertEquals("avinav",ranking.get(0).getName());
		assertEquals("raj",ranking.get(1).getName());
		assertEquals("mayank",ranking.get(2).getName());
		assertEquals("himesh",ranking.get(3).getName());
		assertEquals("akriti",ranking.get(4).getName());
		
		
	}

}
