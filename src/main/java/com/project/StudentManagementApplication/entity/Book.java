package com.project.StudentManagementApplication.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Book_Table")
public class Book {

    @Id
    @Column(name = "book_id")
    private Integer bookId;
    private String bookName;
}
