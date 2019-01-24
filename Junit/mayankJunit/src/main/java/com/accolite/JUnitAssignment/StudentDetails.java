package com.accolite.JUnitAssignment;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentDetails {
	@Id
	@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	@Column(name = "name")
	public String  name;
	
	@Column(name = "percentage")
	public int  percentage;
	
	@Column(name = "dob")
	public String  dob;
	
	
	
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setMarks(int marks) {
		this.percentage = marks;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setStudentId(Integer studentId) {
		this.id = studentId;
	}

	public String getName() {
		return name;
	}

	public void setStudentName(String studentName) {
		this.name = studentName;
	}
	
}
