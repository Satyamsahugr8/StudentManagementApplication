package com.project.StudentManagementApplication;

import com.project.StudentManagementApplication.entity.Course;
import com.project.StudentManagementApplication.entity.Student;
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
    public void run(String... args) {

        Course course1 = new Course();
        course1.setCourseId(5);
        course1.setTitle("C++");

        Course course2 = new Course();
        course2.setCourseId(6);
        course2.setTitle("Python");

        Course course3 = new Course();
        course3.setCourseId(7);
        course3.setTitle("Java");

        Course course4 = new Course();
        course3.setCourseId(1);
        course4.setTitle("Abap");

        Student student1 = new Student();
        student1.setStudentId(64);
        student1.setFirstName("Aman");

        Student student2 = new Student();
        student2.setStudentId(65);
        student2.setFirstName("bipin");

        List<Course> courses1 = new ArrayList<>();
        courses1.add(course1);
        courses1.add(course2);
        courses1.add(course3);


        List<Course> courses2 = new ArrayList<>();
        courses2.add(course1);
        courses2.add(course2);
        courses2.add(course4);

        student1.setCourses(courses1);
        student2.setCourses(courses2);

        studentRepository.save(student1);
        studentRepository.save(student2);

    }
}