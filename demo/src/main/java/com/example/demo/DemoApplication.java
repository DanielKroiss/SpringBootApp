package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (UserRepository repository){
		return args -> {
			repository.save(new User("Daniel", "Kroiß", "daniel_kroiss@gmx.at"));
			repository.save(new User("Jasmin", "Gorski", "jasmin.gorski@teclead.de"));
			repository.save(new User("Daniel", "Mustermann", "daniel.mustermann@gmx.at"));
		};
	}

}
