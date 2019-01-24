package com.accolite.JUnitAssignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rankTable")
public class Ranking {
	
	@Id
	
	
	@Column(name="id")
	public int id;
	
	@Column(name = "name")
	public String  name;
	
	@Column(name = "percentage")
	public int  percentage;
	
	@Column(name = "dob")
	public String  dob;
	
	@Column(name = "studentRank")
	public int  studentRank;
	
	
	
	public int getStudentRank() {
		return studentRank;
	}

	public void setStudentRank(int studentRank) {
		this.studentRank = studentRank;
	}

	public int getId() {
		return id;
	}

	public void setId(int studentId) {
		this.id = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String studentName) {
		this.name = studentName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int marks) {
		this.percentage = marks;
	}
	
	

}
