package com.project.StudentManagementApplication.service;

import com.project.StudentManagementApplication.entity.Address;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;
    @MockBean
    private StudentRepository studentRepository;
    private Student student;
    @BeforeEach
    void setUp() {
        student = Student.builder()
                .firstName("mayank")
                .lastName("sahu")
                .age(24)
                .build();
    }

    @Test
    public void validateStudentName_thenReturnStudent() {
        String studentFirstName = "mayank";
        Student studentFound = studentService.getStudentbyFirstName(studentFirstName);

        Mockito.when(studentRepository.findByFirstName("mayank")).thenReturn(student);
        assertEquals(studentFound.getFirstName(), studentFirstName);
    }
}