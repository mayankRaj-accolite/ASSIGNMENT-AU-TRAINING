package hibernetAssignment.mayank;


import javax.persistence.Table;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="student")
public class Student {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer studentId;

	@Column(name="name")
	public String studentName;

	@Column(name="age")
	public Integer studentAge;
	
	 @OneToMany(mappedBy="studentId", fetch=FetchType.EAGER) public List<Course>
	  courses;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	

}
