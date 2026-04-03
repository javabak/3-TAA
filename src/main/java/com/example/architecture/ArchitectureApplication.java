package com.example.architecture;

import com.example.architecture.configuration.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RabbitConfiguration.class)
public class ArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchitectureApplication.class, args);
	}
}
