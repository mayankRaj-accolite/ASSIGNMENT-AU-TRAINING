package com.au.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.spring.dao.StudentDAO;
import com.au.spring.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDAO studentDAO;
	
	public List<Student> getName() {
		return studentDAO.getName();
	}

	public void insertDetails(Student student) {

		studentDAO.insertDetails(student);
	}
	
	

}
