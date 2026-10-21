package com.example.studentmanagement;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class StudentManagementApplicationTests {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void clearStudents() {
        studentService.getAllStudents().forEach(student -> studentService.deleteStudent(student.getId()));
    }

    @Test
    void applicationContextLoads() {
        assertThat(studentService).isNotNull();
    }

    @Test
    void savesAndGetsStudent() {
        Student student = new Student("Test Student", "TEST001", "test@example.edu",
                "1234567890", "Computer Science", 1, "A", "Test address");

        Student savedStudent = studentService.saveStudent(student);

        assertThat(savedStudent.getId()).isNotNull();
        assertThat(studentService.getStudentById(savedStudent.getId()))
                .isPresent()
                .get()
                .extracting(Student::getName)
                .isEqualTo("Test Student");
    }

    @Test
    void loginPageIsPublic() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void studentsPageRedirectsWhenUnauthenticated() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", containsString("/login")));
    }
}
