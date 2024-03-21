package com.project.StudentManagementApplication.repository;

import com.project.StudentManagementApplication.entity.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private TestEntityManager entityManager;
    private Student student;
    @BeforeEach
    void setUp() {
        student = Student.builder()
                .firstName("satyam")
                .lastName("sahu")
                .age(24)
                .build();

        entityManager.persist(student);
    }

    @Test
    public void whenFindById_thenReturnStudent() {
        String studentFirstName = "mayank";
        Student studentFound = studentRepository.findById(1).get();
        assertEquals(studentFound.getFirstName(), studentFirstName);
    }

    @Test
    @DisplayName("JUnit test for save student operation")
    public void givenStudentObject_whenSave_thenReturnSaveStudent(){

        // When : Action of behavious that we are going to test
        Student saveStudent = studentRepository.save(student);
        // Then : Verify the output
        Assertions.assertThat(saveStudent).isNotNull();
        Assertions.assertThat(saveStudent.getStudentId()).isGreaterThan(0);
    }
}