package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Guardian;
import com.project.StudentManagementApplication.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest2 {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudentByEmailAddress() {

//        Guardian guardian = Guardian.builder()
//                .email("nikhil@gmail.com")
//                .name("Nikhil")
//                .mobile("9999956324")
//                .build();
//
//        Student student = Student.builder()
//                .emailId("shabbir@gmail.com")
//                .firstName("Shabbir")
//                .lastName("Dawoodi")
//                .guardian(guardian)
//                .build();

        Student student = studentRepository.getStudentByEmailAddress("shabbir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress() {

        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("shabbir@gmail.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }
    
    @Test
    public void getStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("shabbir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNative("shabbir@gmail.com");
        System.out.println("student = " + student);
    }
}
