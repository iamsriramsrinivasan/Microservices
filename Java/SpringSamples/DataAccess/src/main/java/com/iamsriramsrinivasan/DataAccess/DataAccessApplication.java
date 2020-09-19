package com.iamsriramsrinivasan.DataAccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DataAccessApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DataAccessApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DataAccessApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating Students Table....");

		jdbcTemplate.execute("DROP TABLE students IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE students (id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

		List<Object[]> splitNames = Arrays.asList("Sriram Srinivasan", "Madhangi Sriram", "Sadhana Sriram", "Viswanathan Sriram")
				.stream()
				.map(name -> name.split(" "))
				.collect(Collectors.toList());

		splitNames.forEach(name -> log.info(String.format("Inserting student record for %s %s", name[0], name[1])));

		jdbcTemplate.batchUpdate("INSERT INTO students(first_name, last_name) VALUES (?,?)", splitNames);

		log.info("Querying for student records where first_name = 'Sadhana':");

		jdbcTemplate.query(
				"SELECT id, first_name, last_name FROM students WHERE first_name = ?", new Object[] { "Sadhana" },
				(rs, rowNum) -> new Student(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
		).forEach(student -> log.info(student.toString()));
	}


}
