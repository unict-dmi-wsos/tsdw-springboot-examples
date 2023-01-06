package edu.unict.tswd.springboot.student.data;

import edu.unict.tswd.springboot.student.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements StudentBaseRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from student", Integer.class);
    }

    @Override
    public int save(Student student) {
        return jdbcTemplate.update(
                "insert into student (name) values(?)",
                student.getName());
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update(
                "update student set name = ? where id = ?",
                student.getName(), student.getId());
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(
                "select * from student",
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
        );
    }
}
