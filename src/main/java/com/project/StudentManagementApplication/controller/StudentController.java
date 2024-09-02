package com.project.StudentManagementApplication.controller;

import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
		Student savedUser = studentService.saveStudent(student);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudentbyId(@PathVariable ("id") int id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable ("id") int studentId) {
		Student existingStudent = studentService.getStudentById(studentId);
		studentService.updateStudent(existingStudent, student);
		studentService.saveStudent(existingStudent);
		return new ResponseEntity<>(existingStudent, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable ("id") int studentId) {
		Student existingStudent = studentService.getStudentById(studentId);
		studentService.deleteStudent(existingStudent);
		return new ResponseEntity<>("student Deleted", HttpStatus.OK);
	}

	@DeleteMapping("/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents() {
		studentService.deleteAllStudents();
		return new ResponseEntity<>("All student Deleted", HttpStatus.OK);
	}

}
