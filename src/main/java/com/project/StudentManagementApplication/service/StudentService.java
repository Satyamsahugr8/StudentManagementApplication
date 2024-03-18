package com.project.StudentManagementApplication.service;

import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.exception.StudentNotFoundException;
import java.util.List;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int userId) throws StudentNotFoundException;

	void deleteStudent(Student existingStudent);

	void deleteAllStudents();

	Student updateStudent(Student student, Student existingStudent);

	Student getStudentbyFirstName(String firstName);

	Student getStudentbyFirstNameIgnoreCase(String firstName);
}
