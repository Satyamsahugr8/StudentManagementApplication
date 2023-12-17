package com.project.StudentManagementApplication.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Student_Table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	int student_id;
	String firstName;
	String lastName;
	int age;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
	@JoinColumn(name = "address_id")
	private Address address;

}
