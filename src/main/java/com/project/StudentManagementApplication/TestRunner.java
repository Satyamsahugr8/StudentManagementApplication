package com.project.StudentManagementApplication;

import com.project.StudentManagementApplication.entity.Address;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRunner implements CommandLineRunner{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

        Address address = new Address();
        address.setAddress_id(1);
        address.setAddress("#1 prachii vignan nagar");

        Student student1 = new Student();
        student1.setStudent_id(1);
        student1.setFirstName("satyam");
        student1.setLastName("sahu");

        student1.setAddress(address);
        address.setStudent(student1);

//        Student student2 = new Student(2,"sanu", "kumar", 23, book1);
//        Student student3 = new Student(3,"anil", "sahu", 18, book1);
//        Student student4 = new Student(4,"priyanka", "gowda", 21, book2);

        studentRepository.save(student1);
//        studentRepository.save(student2);
//        studentRepository.save(student3);
//        studentRepository.save(student4);
    }
}
