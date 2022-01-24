package com.mongodb.practice.demo.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository,
							 MongoTemplate mongoTemplate) {
		return args -> {
			Address address = new Address("Germany", "Frankfurt", "65428");
			String email = "saadkhan@abc.com";
			Student student = new Student(
					"saad",
					"Khan",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science", "English"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);


			repository.findStudentByEmail(email)
					.ifPresentOrElse(s -> {
					}, () -> {
						repository.insert(student);
					});
		};
	}
	}





