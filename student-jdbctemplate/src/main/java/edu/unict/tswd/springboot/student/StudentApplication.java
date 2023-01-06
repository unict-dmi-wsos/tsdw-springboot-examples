package edu.unict.tswd.springboot.student;

import edu.unict.tswd.springboot.student.data.StudentBaseRepository;
import edu.unict.tswd.springboot.student.data.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StudentApplication {

	/*JdbcTemplate jdbcTemplate;
	@Qualifier("StudentRepository")
	private StudentBaseRepository studentRepository;
*/
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
