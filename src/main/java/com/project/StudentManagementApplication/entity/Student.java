package com.project.StudentManagementApplication.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Student_Table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_Id")
	int studentId;
	String firstName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course_Table", joinColumns = { @JoinColumn(name = "student_Id") }, inverseJoinColumns = { @JoinColumn(name = "course_Id") })
	private List<Course> courses;

}
