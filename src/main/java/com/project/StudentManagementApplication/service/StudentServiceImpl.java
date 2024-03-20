package com.project.StudentManagementApplication.service;

import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.exception.StudentNotFoundException;
import com.project.StudentManagementApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public Student saveStudent(Student student) {
		// here this is required in order to map from address side too
//		Address address = student.getAddress();
//		address.setStudent(student);
		return studentRepository.save(student);
	}

    @Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
    
	@Override
	public Student getStudentById(@RequestBody int studentId) throws StudentNotFoundException {
		Optional<Student> student = studentRepository.findById(studentId);
		if (!student.isPresent()) {
			throw new StudentNotFoundException("Student not found");
		}
		return student.get();
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
		existingStudent.setLastName(student.getLastName());
		existingStudent.setAge(student.getAge());
//		existingStudent.setAddress(student.getAddress());
		return existingStudent;
	}

	@Override
	public Student getStudentbyFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	@Override
	public Student getStudentbyFirstNameIgnoreCase(String firstName) {
		return studentRepository.findByFirstNameIgnoreCase(firstName);
	}

}
