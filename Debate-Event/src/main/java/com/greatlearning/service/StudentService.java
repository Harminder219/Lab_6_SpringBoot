package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.entity.Student;

public interface StudentService {

	
	public List<Student> getStudentdetails();
	
	public Optional<Student> getStudentById(int id);
	
	public void saveStudentDetails(Student student);
	
	public void deleteStudent(int id);
	
	
}
