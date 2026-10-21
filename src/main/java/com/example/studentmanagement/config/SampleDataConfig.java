package com.example.studentmanagement.config;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleDataConfig {

    @Bean
    public CommandLineRunner loadSampleStudents(StudentRepository studentRepository) {
        return args -> {
            if (studentRepository.count() == 0) {
                studentRepository.save(new Student("Aarav Sharma", "CS2024001", "aarav@example.edu",
                        "9876543210", "Computer Science", 2, "A", "12 College Road"));
                studentRepository.save(new Student("Diya Patel", "CS2024002", "diya@example.edu",
                        "9876543211", "Computer Science", 1, "B", "8 Lake View"));
                studentRepository.save(new Student("Ishaan Kumar", "EC2024001", "ishaan@example.edu",
                        "9876543212", "Electronics", 3, "A", "25 Park Street"));
                studentRepository.save(new Student("Meera Nair", "ME2024001", "meera@example.edu",
                        "9876543213", "Mechanical", 2, "C", "4 Hill Road"));
                studentRepository.save(new Student("Kabir Singh", "IT2024001", "kabir@example.edu",
                        "9876543214", "Information Technology", 4, "A", "17 Garden Avenue"));
            }
        };
    }
}
