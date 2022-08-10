package com.example.springmvc2;

import com.example.springmvc2.entities.Role;
import com.example.springmvc2.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMvc2Application {

	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvc2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() throws Exception {
		return args -> {
			try {
				roleRepository.saveAll(List.of(
						new Role("ADMIN"),
						new Role("USER_BASIC"),
						new Role("USER_ADVANCED")
				));
			} catch (Exception e) {

			}
		};
	}
}
