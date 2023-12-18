package com.project.StudentManagementApplication.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Address_Table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_Id")
    private int addressId;
    private String address;

//    @ManyToMany(mappedBy = "address")
//    private List<Student> student;

}
