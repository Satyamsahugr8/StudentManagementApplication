package com.project.StudentManagementApplication;

import com.project.StudentManagementApplication.entity.Address;
import com.project.StudentManagementApplication.entity.Course;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.repository.AddressRepository;
import com.project.StudentManagementApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRunner implements CommandLineRunner{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Course course1 = new Course();
        course1.setTitle("C++");

        Course course2 = new Course();
        course2.setTitle("Python");

        Course course3 = new Course();
        course3.setTitle("Java");

        Course course4 = new Course();
        course4.setTitle("Abap");

        Student student1 = new Student();
        student1.setFirstName("Aman");
        List<Course> courses1 = new ArrayList<>();
        courses1.add(course1);
        courses1.add(course3);
        student1.setCourses(courses1);

        Student student2 = new Student();
        student2.setFirstName("bipin");
        List<Course> courses2 = new ArrayList<>();
        courses2.add(course4);
        courses2.add(course2);
        student2.setCourses(courses2);

//        Student student3 = new Student();
//        student3.setFirstName("chinmay");
//        List<Course> courses3 = new ArrayList<>();
////        courses3.add(course5);
//        student3.setCourses(courses3);

        studentRepository.save(student1);
        studentRepository.save(student2);
//        studentRepository.save(student3);

    }
}