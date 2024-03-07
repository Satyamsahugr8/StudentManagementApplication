package com.project.StudentManagementApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@Table(name = "Address_Table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int address_id;
    private String address;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "student_Id")
    private Student student;

}
