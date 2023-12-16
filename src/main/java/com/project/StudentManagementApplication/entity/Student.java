package com.project.StudentManagementApplication.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student_Table")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	int student_id;
	String firstName;
	String lastName;
	int age;

	//onedirectional
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="Student_Address", joinColumns= @JoinColumn(name="student_id"), inverseJoinColumns=@JoinColumn(name="address_id"))
//	private List<Address> address = new ArrayList<>();

	//bidirectional
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Address> address = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(int student_id, String firstName, String lastName, int age, List<Address> address) {
		this.student_id = student_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"student_id=" + student_id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", address=" + address +
				'}';
	}
}
