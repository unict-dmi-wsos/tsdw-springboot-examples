package edu.unict.tswd.springboot.student.data;

import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // Methods to search for name
    List<Student> findByName(String name);
}
