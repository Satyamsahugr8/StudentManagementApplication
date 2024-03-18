package com.project.StudentManagementApplication.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Student_Table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	int student_id;
	@NotBlank(message = "firstName required")
	@Length( min = 5 , max = 20)
	String firstName;
	String lastName;
	int age;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
	@JoinColumn(name = "address_id")
	private Address address;

}
