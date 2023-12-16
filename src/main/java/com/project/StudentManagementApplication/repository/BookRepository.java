package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{
}
