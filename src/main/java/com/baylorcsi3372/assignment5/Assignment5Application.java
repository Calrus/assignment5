package com.baylorcsi3372.assignment5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.baylorcsi3372.assignment5")
public class Assignment5Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Assignment5Application.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating TvShow table");
		
		jdbcTemplate.execute("DROP TABLE IF EXISTS tv_show");

		jdbcTemplate.execute("CREATE TABLE tv_show(" +
				"id SERIAL PRIMARY KEY, " +
				"title VARCHAR(255), " +
				"runtime VARCHAR(50), " +
				"rating DOUBLE PRECISION, " +
				"show_year INTEGER, " +
				"votes INTEGER)"
		);

		log.info("TvShow table created successfully.");
	}
}
