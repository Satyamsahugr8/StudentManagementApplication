package com.project.StudentManagementApplication.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Address_Table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int address_id;
    private String address;

    @OneToOne
    @JoinColumn(name = "student_Id")
    private Student student;

}
