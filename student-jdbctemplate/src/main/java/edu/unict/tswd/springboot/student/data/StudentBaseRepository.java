package edu.unict.tswd.springboot.student.data;
import edu.unict.tswd.springboot.student.models.Student;
import java.util.List;

public interface StudentBaseRepository {
    int count();
    int save(Student student);
    int update(Student student);
    List<Student> findAll();
}
