package com.emilpersson.coachbackend.config;

import com.emilpersson.coachbackend.db.GameRepository;
import com.emilpersson.coachbackend.service.CoachService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    CoachService coachService(GameRepository gameRepository) {
        return new CoachService(gameRepository);
    }
}
