package com.project.StudentManagementApplication.service.impl;

import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.repository.StudentRepository;
import com.project.StudentManagementApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

    @Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
    
	@Override
	public Student getStudentById(@RequestBody int userId) {
		return studentRepository.findById(userId).get();
	public Student getUserById(@RequestBody int userId) {
		Optional optional = studentRepository.findById(userId);
		Student student = null;
		if (optional.isPresent()) {
			student = (Student) optional.get();
		}
		return student;
	}
	
	@Override
	public void deleteStudent(Student existingStudent) {
		studentRepository.delete(existingStudent);
	}

	@Override
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}

	@Override
	public Student updateStudent(Student existingStudent, Student student) {
		existingStudent.setFirstName(student.getFirstName());
//		existingStudent.setLastName(student.getLastName());
//		existingStudent.setAge(student.getAge());
//		existingStudent.setAddress(student.getAddress());
		return existingStudent;
	}

}
