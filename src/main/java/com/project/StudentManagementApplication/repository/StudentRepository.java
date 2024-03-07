package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

    public Student findByFirstName(String firstName);
    public Student findByFirstNameIgnoreCase(String firstName);

}
