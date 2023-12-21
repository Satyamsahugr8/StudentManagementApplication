package com.project.StudentManagementApplication.service;

import com.project.StudentManagementApplication.entity.Student;
import java.util.List;

public interface StudentService {
	
	Student saveUser(Student user);

	List<Student> getAllUsers();

	Student getUserById(int userId);

	void deleteUser(Student existingUser);

	void deleteAllUser();

	void updateUser(Student user, Student existingUser);
}
