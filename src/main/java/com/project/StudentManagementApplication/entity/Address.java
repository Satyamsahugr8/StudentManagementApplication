package com.project.StudentManagementApplication.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString@Getter
@Setter
@Table(name = "Address_Table")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;
    private String address;

}
