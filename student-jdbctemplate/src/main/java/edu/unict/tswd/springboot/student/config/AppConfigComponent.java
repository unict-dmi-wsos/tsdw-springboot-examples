package edu.unict.tswd.springboot.student.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppConfigComponent {
    private final JdbcTemplate jdbcTemplate;

    public AppConfigComponent(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
