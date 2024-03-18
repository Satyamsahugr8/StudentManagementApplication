package com.project.StudentManagementApplication.controller;

import com.project.StudentManagementApplication.entity.Address;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.exception.StudentNotFoundException;
import com.project.StudentManagementApplication.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

	private final StudentService studentService;
	private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

//	@PostMapping("/addStudent")
	@RequestMapping(method = {RequestMethod.POST}, value = "/addStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		LOGGER.info("inside saveStudent of StudentController");
		Student savedUser = studentService.saveStudent(student);
		return new ResponseEntity<>(savedUser, HttpStatus.OK);
	}
	
//	@GetMapping("/getAllStudents")
	@RequestMapping(method = {RequestMethod.GET}, value = "/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}

//	@GetMapping("/getStudent/{id}")
	@RequestMapping(method = {RequestMethod.GET}, value = "/getStudent/{id}")
	public ResponseEntity<Student> getStudentbyId(@PathVariable("id") int id) throws StudentNotFoundException {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@GetMapping("/getStudent/firstName/{firstName}")
//	@RequestMapping(method = {RequestMethod.GET}, value = "/getStudent/firstName/{firstName}")
	public ResponseEntity<Student> getStudentbyFirstName(@PathVariable("firstName") String firstName) {
//		Student student = studentService.getStudentbyFirstName(firstName);
		Student student = studentService.getStudentbyFirstNameIgnoreCase(firstName);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
//	@RequestMapping(method = {RequestMethod.PUT}, value = "/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) throws StudentNotFoundException {
		Student existingStudent = studentService.getStudentById(studentId);
		studentService.updateStudent(existingStudent, student);
		studentService.saveStudent(existingStudent);
		return new ResponseEntity<>(existingStudent, HttpStatus.ACCEPTED);
	}

//	@DeleteMapping("/deleteStudent/{id}")
	@RequestMapping(method = {RequestMethod.DELETE}, value = "/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable ("id") int studentId) throws StudentNotFoundException {
		Student existingStudent = studentService.getStudentById(studentId);
		studentService.deleteStudent(existingStudent);
		return new ResponseEntity<>("student Deleted", HttpStatus.OK);
	}

//	@DeleteMapping("/deleteAllStudents")
	@RequestMapping(method = {RequestMethod.DELETE}, value = "/deleteAllStudents")
	public ResponseEntity<String> deleteAllStudents() {
		studentService.deleteAllStudents();
		return new ResponseEntity<>("All student Deleted", HttpStatus.OK);
	}

}
