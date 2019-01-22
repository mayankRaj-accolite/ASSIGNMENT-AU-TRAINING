package com.spring.au;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("jdbcTemplateDao")
public class JDBCTemplateDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int saveStudent(Student student){
		
		String query = "insert into student values ("+student.getStudentId()+",'"+student.getStudentName()+"')";
		return jdbcTemplate.update(query);
	}
public List<Student> findall() {
	return jdbcTemplate.query("Select * from student",new ApplicationMapper());
}

}
