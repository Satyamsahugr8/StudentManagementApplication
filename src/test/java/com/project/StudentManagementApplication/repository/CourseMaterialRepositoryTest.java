package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Course;
import com.project.StudentManagementApplication.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                        .title(".net-2")
                        .credit(7)
                        .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                        .url("www.dotnet.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials =
                courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}