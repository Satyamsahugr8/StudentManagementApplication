package com.project.StudentManagementApplication.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "courses")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long teacherId;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private List<Course> courses;
}