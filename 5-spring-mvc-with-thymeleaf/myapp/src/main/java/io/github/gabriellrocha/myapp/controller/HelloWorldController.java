package io.github.gabriellrocha.myapp.controller;

import io.github.gabriellrocha.myapp.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Introduction

    @GetMapping("/show-form")
    public String showForm() {
        return "show-form";
    }

    @PostMapping("/process-form")
    public String processForm(@RequestParam String studentName, Model model) {
        model.addAttribute("studentName", studentName.toUpperCase());
        return "process-form";
    }

    // Introduction to a @ModelAttribute

    @GetMapping("/show-form-student")
    public String showFormStudent(Model model) {

        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/process-form-student")
    public String processStudentForm(@ModelAttribute Student student) {
        // @ModelAttribute - Data binding automático do Spring MVC
        // Cria, popula e expoe o Obj p/ a View automaticamente

        System.out.println(student);

        return "student-confirmation";
    }
}
