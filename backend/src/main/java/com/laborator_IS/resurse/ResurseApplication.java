package com.laborator_IS.resurse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class ResurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResurseApplication.class, args);
	}

	//puteti face initializarile si aici (daca lucrati cu create-drop)

//	@Bean //face ca metoda sa fie executata la inceputul fiecarei rulari
//	CommandLineRunner init() {
//		return args -> {

//		};
//	}

}
