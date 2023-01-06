package edu.unict.tswd.springboot.student.controllers;

import edu.unict.tswd.springboot.student.data.StudentRepository;
import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/students")
public class StudentsController {
    private final StudentRepository studentRepository;

    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("count",studentRepository.count());
        return "students"; // Name of the template
    }

}
