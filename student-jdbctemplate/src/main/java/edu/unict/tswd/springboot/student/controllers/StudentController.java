package edu.unict.tswd.springboot.student.controllers;

import edu.unict.tswd.springboot.student.data.StudentRepository;
import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student"; // Invoke ThymeLeaf template
    }

    @PostMapping
    public String studentSubmit(@ModelAttribute Student student, Model model){
        studentRepository.save(student);// Save the new student to database
        model.addAttribute("student", student);
        return "newStudentResult"; // Invoke ThymeLeaf template
    }
}
