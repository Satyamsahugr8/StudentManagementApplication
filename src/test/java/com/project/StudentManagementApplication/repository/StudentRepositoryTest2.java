package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@Transactional
public class StudentRepositoryTest2 {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveStudent() {

//        Course course = courseRepository.getById(1L);

        Course course2 = Course.builder()
                .title("english")
                .credit(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.english.com")
                .course(course2)
                .build();

        course2.setCourseMaterial(courseMaterial);

        Teacher teacher = Teacher.builder()
                .firstName("suman")
                .lastName("sahu")
                .courses(List.of(course2))
                .build();

        course2.setTeacher(teacher);

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .age(24)
                .guardian(guardian)
                .courses(List.of(course2))
                .build();

        course2.setStudents(List.of(student));

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

    @Test
    public void saveStudentWithCourses() {

    }

    @Test
    public void printAllStudentsWithCourses() {

    }

    @Test
    public void addStudentToCurrentCourse() {

    }

}
