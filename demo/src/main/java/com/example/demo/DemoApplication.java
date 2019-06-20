package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	
	@Bean
	CommandLineRunner init(StudentRepository repository) {
		return args ->{
			Date date = new Date();
			repository.save(new Student("John", "ward", "WardJ@gmail.com", date));
			repository.save(new Student("Said", "Wej", "SaidW@yahoo.fr", date));
			repository.save(new Student("Sarrah", "Ali", "AliS@hotmail.com", date));
		};
	}
}
