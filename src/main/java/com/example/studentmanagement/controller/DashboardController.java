package com.example.studentmanagement.controller;

import com.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final StudentService studentService;

    public DashboardController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("studentCount", studentService.countStudents());
        model.addAttribute("departmentCount", studentService.countDepartments());
        return "dashboard";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
