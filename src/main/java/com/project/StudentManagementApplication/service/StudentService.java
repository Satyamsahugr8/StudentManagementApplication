package com.project.StudentManagementApplication.service;

import com.project.StudentManagementApplication.entity.Student;
import java.util.List;

public interface StudentService {
	
	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int studentId);

	void deleteStudent(Student existingStudent);

	void deleteAllStudents();

	Student updateStudent(Student user, Student existingStudent);
}
