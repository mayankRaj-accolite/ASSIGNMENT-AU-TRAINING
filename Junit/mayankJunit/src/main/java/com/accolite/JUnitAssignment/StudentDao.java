package com.accolite.JUnitAssignment;

import java.util.List;

public interface StudentDao {
	public List<StudentDetails> getStudents();
	public void saveStudent(StudentDetails student);
	public void notifyStudent(StudentDetails student);
}
