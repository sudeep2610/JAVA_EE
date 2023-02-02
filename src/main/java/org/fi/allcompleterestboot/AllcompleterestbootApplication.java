package org.fi.allcompleterestboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.fi.allcompleterestboot.controllers","org.fi.allcompleterestboot.services"})
@EntityScan(basePackages = {"org.fi.allcompleterestboot.entity"})
@EnableJpaRepositories(basePackages = {"org.fi.allcompleterestboot.repositories"})
public class AllcompleterestbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllcompleterestbootApplication.class, args);
	}

}
