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
	@Column(name = "student_id")
	int studentId;
	String firstName;
	String lastName;
	int age;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Address> address;

}
