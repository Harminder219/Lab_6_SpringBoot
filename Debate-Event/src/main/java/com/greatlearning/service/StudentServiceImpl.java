package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Student;
import com.greatlearning.repository.StudentRepository;

@Service
public class StudentServiceImpl implements  StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudentdetails() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		
		return studentRepository.findById(id);
	}

	@Override
	public void saveStudentDetails(Student student) {
		
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
		studentRepository.deleteById(id);
	}

}
