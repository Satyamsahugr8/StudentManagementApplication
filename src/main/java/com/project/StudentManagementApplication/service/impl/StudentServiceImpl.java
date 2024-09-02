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
	public Student saveUser(Student user) {
		return studentRepository.save(user);
	}

    @Override
	public List<Student> getAllUsers() {
		return (List<Student>) studentRepository.findAll();
	}
    
	@Override
	public Student getUserById(@RequestBody int userId) {
		Optional optional = studentRepository.findById(userId);
		Student student = null;
		if (optional.isPresent()) {
			student = (Student) optional.get();
		}
		return student;
	}
	
	@Override
	public void deleteUser(Student existingUser) {
		studentRepository.delete(existingUser);
	}

	@Override
	public void deleteAllUser() {
		studentRepository.deleteAll();
	}

	@Override
	public Student updateUser(Student existingStudent, Student student) {
		existingStudent.setFirstName(student.getFirstName());
//		existingStudent.setLastName(student.getLastName());
//		existingStudent.setAge(student.getAge());
//		existingStudent.setAddress(student.getAddress());
		return existingStudent;
	}

}
