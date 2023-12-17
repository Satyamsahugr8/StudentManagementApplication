package com.project.StudentManagementApplication.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Student_Table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	int studentId;
	String firstName;
	String lastName;
	int age;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_book_Table", joinColumns = @JoinColumn(name = "student_Id"), inverseJoinColumns = @JoinColumn(name = "book_Id"))
	private List<Book> book;

}
