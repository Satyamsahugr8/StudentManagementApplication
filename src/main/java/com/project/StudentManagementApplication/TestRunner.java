package com.project.StudentManagementApplication;

import com.project.StudentManagementApplication.entity.Address;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.repository.AddressRepository;
import com.project.StudentManagementApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRunner implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Address a1 = new Address();
        a1.setAddress("#1 prachii vignan nagar");

        Address a2 = new Address();
        a2.setAddress("#143 Housing park colony");

        List<Address> addresses = new ArrayList<>();
        addresses.add(a1);
        addresses.add(a2);

        Student student1 = new Student();
        student1.setFirstName("satyam");
        student1.setLastName("sahu");
        student1.setAge(24);
        student1.setAddress(addresses);

        a1.setStudent(student1);
        a2.setStudent(student1);

        studentRepository.save(student1);

    }
}