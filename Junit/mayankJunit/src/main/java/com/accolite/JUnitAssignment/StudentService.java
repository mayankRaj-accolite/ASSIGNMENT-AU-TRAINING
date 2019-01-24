package com.accolite.JUnitAssignment;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class StudentService {
	public StudentDao daoVariable;

	public StudentDao getDaoVariable() {
		return daoVariable;
	}

	public void setDaoVariable(StudentDao dao) {
		this.daoVariable = dao;
	}

	public List<Ranking> getRankList(List<StudentDetails> studentList) {
		
		Collections.sort(studentList, new RankCompare());
		List<Ranking> studentRankList= new ArrayList<Ranking>();
		
		int student_rank = 0;
		
		for (StudentDetails s : studentList) {
			
			student_rank++;
			Ranking rank = new Ranking();
			rank.setStudentRank(student_rank);
			rank.setId(s.getId());
			rank.setName(s.getName());
			rank.setDob(s.getDob());
			rank.setPercentage(s.getPercentage());
			studentRankList.add(rank);
			//daoVariable.notifyStudent(s);
			
		}
		
		
		return studentRankList;
	}

}
