package com.project.StudentManagementApplication.controller;

import com.project.StudentManagementApplication.entity.Student;
import com.project.StudentManagementApplication.exception.StudentNotFoundException;
import com.project.StudentManagementApplication.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;
//import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;
    private Student student;
    @BeforeEach
    void setUp() {
        student = Student.builder()
                .firstName("satyam")
                .lastName("sahu")
                .age(24)
                .student_id(1)
                .build();
    }

    @Test
    void saveStudent() throws Exception {
        Student inputStudent = Student.builder()
                .firstName("satyam")
                .lastName("sahu")
                .age(24)
                .build();
        Mockito.when(studentService.saveStudent(inputStudent)).thenReturn(student);

        mockMvc.perform(post("/api/v1/addStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"firstName\": \"satyam\",\n" +
                                "    \"lastName\": \"sahu\",\n" +
                                "    \"age\": \"24\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getStudentId() throws Exception {
        Mockito.when(studentService.getStudentById(1)).thenReturn(student);

        mockMvc.perform(get("/api/v1/getStudent/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}