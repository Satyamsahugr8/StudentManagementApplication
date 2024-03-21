package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Course;
import com.project.StudentManagementApplication.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveCourse() {

//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url("www.codejava.com")
//                .build();
//
//        Course course = Course.builder()
//                .title("JAVA")
//                .credit(6)
//                .courseMaterial(courseMaterial)
//                .build();

        Course course = Course.builder()
                .title("english")
                .credit(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.english.com")
                .course(course)
                .build();

        course.setCourseMaterial(courseMaterial);
        courseRepository.save(course);
    }

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
}