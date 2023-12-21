package com.project.StudentManagementApplication.controller;

import com.project.StudentManagementApplication.configuration.Common;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/addStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student savedUser = studentService.saveUser(student);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllUsers() {
		return new ResponseEntity<>(studentService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getUserbyId(@PathVariable ("id") int id) {
		Student user = studentService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateUser(@RequestBody Student user, @PathVariable ("id") int userId) {
		Student existingUser = studentService.getUserById(userId);
		studentService.updateUser(existingUser, user);
		studentService.saveUser(existingUser);
		return new ResponseEntity<>(existingUser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable ("id") int userId) {
		Student existingUser = studentService.getUserById(userId);
		studentService.deleteUser(existingUser);
		return new ResponseEntity<>("user Deleted", HttpStatus.OK);
	}

	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllUsers() {
		studentService.deleteAllUser();
		return new ResponseEntity<>("all user Deleted", HttpStatus.OK);
	}

	@GetMapping("/value")
	public ResponseEntity<String> value( @Value("${myapp.title}") String title, @Value("${myapp.version}") String version, @Value("${myapp.build}") String build ) {
		return new ResponseEntity<>(title +"|"+ version +"|"+ build, HttpStatus.OK);
	}

}
