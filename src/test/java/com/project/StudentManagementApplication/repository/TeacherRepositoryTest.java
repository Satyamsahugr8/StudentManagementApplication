package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Course;
import com.project.StudentManagementApplication.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course1 = Course.builder()
                .title("DSA-striver")
                .credit(9)
                .build();

        Course course2 = Course.builder()
                .title("Java-striver")
                .credit(7)
                .build();

        Course course3 = Course.builder()
                .title("python-striver")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("striver")
                .lastName("sharma")
                .courses(List.of(course1, course2, course3))
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void printTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        System.out.println("teachers = " + teachers);
    }
}