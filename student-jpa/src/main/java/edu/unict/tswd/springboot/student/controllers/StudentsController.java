package edu.unict.tswd.springboot.student.controllers;

import edu.unict.tswd.springboot.student.data.StudentRepository;
import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        return "students"; // Name of the template
    }

    @GetMapping(path="/searchByName/{name}")
    public String getStudentByName(Model model,@PathVariable String name) {
        model.addAttribute("students", studentRepository.findByName(name));
        return "students"; // Name of the template
    }

    @GetMapping(path="/searchByAgeLessThan/{age}")
    public String getStudentByAgesLessTham(Model model,@PathVariable Integer age) {
        model.addAttribute("students", studentRepository.findByAgeLessThanEqual(age));
        return "students"; // Name of the template
    }

}
