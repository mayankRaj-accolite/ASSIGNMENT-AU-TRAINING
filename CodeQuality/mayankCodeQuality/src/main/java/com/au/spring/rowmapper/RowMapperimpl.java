package com.au.spring.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.au.spring.model.Student;

public class RowMapperimpl implements RowMapper<Student>{

	public Student mapRow(ResultSet resultSet, int rownum) throws SQLException {
		Student student=new Student();
		student.setId(resultSet.getInt(1));
		student.setName(resultSet.getString(2));
		return student;
	}

}