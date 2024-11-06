package com.marco.demo;

import com.marco.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

	@Autowired
	ItemRepository groceryItemRepo;


	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}


}
