package com.integration.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.integration.repository.ContactRepository;

@EntityScan("com.integration.model")
@ComponentScan(basePackages = "com.integration")
@EnableReactiveMongoRepositories(basePackageClasses = ContactRepository.class)
@SpringBootApplication
public class ContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}
}
