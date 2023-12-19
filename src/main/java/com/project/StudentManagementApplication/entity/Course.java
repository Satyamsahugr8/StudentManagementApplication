package com.project.StudentManagementApplication.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Course_Table")
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_Id")
    private int courseId;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

}
