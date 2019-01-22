package com.spring.au;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ApplicationMapper implements RowMapper<Student>{

	public Student mapRow(ResultSet resultSet, int rownum) throws SQLException {
		Student student=new Student();
		student.setStudentId(resultSet.getInt(1));
		student.setStudentName(resultSet.getString(2));
		return student;
	}

}
