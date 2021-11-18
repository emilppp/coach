package com.emilpersson.coachbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CoachBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachBackendApplication.class, args);
	}

}
