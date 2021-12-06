package com.emilpersson.coachbackend.service;

import com.emilpersson.coachbackend.db.GameRepository;
import com.emilpersson.coachbackend.model.Game;
import com.emilpersson.coachbackend.model.Round;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CoachService {

    private GameRepository repository;

    public CoachService(GameRepository repository) {
        this.repository = repository;
    }

    public Optional<Game> getGame(Long id) {
        log.info("Getting game {}", id);
        return repository.findById(id);
    }

    public Optional<Round> addRoundToGame(Round round, Long id) {
        log.info("Adding round {} to game {}", round, id);
        Optional<Game> game = repository.findById(id);
        if (game.isPresent()) {
            game.get().addRound(round);
            repository.save(game.get());
            return Optional.of(round);
        } else {
            return Optional.empty();
        }
    }

    public Game createNewGame(Game game) {
        log.info("Creating new game");
        var newGame = new Game(null, game.getMap(), null, LocalDate.now(), game.getTeamOneAgents(), game.getTeamTwoAgents());
        return repository.save(newGame);
    }

    public List<Round> getRounds(Long id) {
        log.info("Getting rounds for game {}", id);
        var game = repository.findById(id);
        return game.map(Game::getRounds)
                .orElse(Collections.emptyList());
    }

    public Iterable<Game> getGames() {
        log.info("Getting all games.");
        return repository.findAll();
    }

}

