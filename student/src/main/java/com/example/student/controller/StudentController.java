package com.example.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Controller
public class StudentController {
    
    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    // Home
    @GetMapping("/")
    public String index() {
        return "index"; // Template "index.html"
    }

    // Read
    @GetMapping("/read")
    public String read(Model model) {
        model.addAttribute("Students", repo.findAll());
        return "read";
    }

    // Insert
    @PostMapping("/insert")
    public String insert(Student student) {
        repo.save(student);
        return "redirect:/read";
    }

    // Delete or Update
    @PostMapping("/form")
    public String form(@RequestParam String action, @RequestParam Long id, Model model) {

        if (action.equals("Modifica")) {
            Student student = repo.findById(id).orElse(null); // Find record in databse
            model.addAttribute("student", student); // Pass record to the form for update
            return "update";
        }
        if (action.equals("Rimuovi")) {
            repo.deleteById(id);
            return "redirect:/read";
        }

        return "read";
    }

    // Update (same code of Insert)
    @PostMapping("/update")
    public String update(Student student) {
        repo.save(student);
        return "redirect:/read";
    }
}

