package com.project.StudentManagementApplication;

import com.project.StudentManagementApplication.entity.Book;
import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.repository.BookRepository;
import com.project.StudentManagementApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestRunner implements CommandLineRunner{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book(101, "dataStructure");
        Book book2 = new Book(102, "dataBase");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        Student student1 = new Student(1,"amit", "gadha", 22, bookList);
        Student student2 = new Student(2,"sanu", "kumar", 23, bookList);
//        Student student3 = new Student(3,"anil", "sahu", 18, book1);
//        Student student4 = new Student(4,"priyanka", "gowda", 21, book2);

        studentRepository.save(student1);
        studentRepository.save(student2);
//        studentRepository.save(student3);
//        studentRepository.save(student4);
    }
}
