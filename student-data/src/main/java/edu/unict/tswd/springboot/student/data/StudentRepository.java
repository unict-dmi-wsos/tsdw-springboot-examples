package edu.unict.tswd.springboot.student.data;

import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
