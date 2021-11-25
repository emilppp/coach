package com.emilpersson.coachbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.emilpersson.coachbackend.model")
public class CoachBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachBackendApplication.class, args);
	}

}
