package edu.unict.tswd.springboot.student.controllers;

import edu.unict.tswd.springboot.student.data.StudentRepository;
import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path="/{id}")
    public String getStudent(Model model,@PathVariable Long id) {
        model.addAttribute("student", studentRepository.getReferenceById(id));
        return "student"; // Invoke ThymeLeaf template
    }

    // Delete Mapping needs ajax request or hidded Method
    // https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.2-Release-Notes#httphiddenmethodfilter-disabled-by-default
    @GetMapping(path="/delete/{id}")
    public String deleteStudent(Model model,@PathVariable Long id) {
        Student student = studentRepository.getReferenceById(id);
        studentRepository.delete(student);
        return "redirect:/students";
    }

    @PostMapping
    public String studentSubmit(@ModelAttribute Student student, Model model){
        Student save = studentRepository.save(student);// Save the new student to database
        model.addAttribute("student", save);
        return "newStudentResult"; // Invoke ThymeLeaf template
    }
}
