package com.project.StudentManagementApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Student_Table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	int student_id;
	String firstName;
	String lastName;
	int age;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Address> address = new ArrayList<>();

}
