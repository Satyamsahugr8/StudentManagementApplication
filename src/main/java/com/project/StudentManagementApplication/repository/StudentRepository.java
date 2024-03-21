package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByFirstName(String firstName);
    public Student findByFirstNameIgnoreCase(String firstName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(value = "SELECT * FROM student_table s where s.student_email = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "SELECT * FROM student_table s where s.student_email = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

}
