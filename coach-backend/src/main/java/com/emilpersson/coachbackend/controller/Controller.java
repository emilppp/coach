package com.emilpersson.coachbackend.controller;

import com.emilpersson.coachbackend.model.Game;
import com.emilpersson.coachbackend.model.Round;
import com.emilpersson.coachbackend.service.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

    private final CoachService coachService;

    public Controller(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping("/games/{id}/rounds")
    public ResponseEntity<Round> addRound(@RequestBody Round round, @PathVariable Long id) {
        return ResponseEntity.of(coachService.addRoundToGame(round, id));
    }

    @GetMapping("/games/{id}/rounds")
    public List<Round> getRounds(@PathVariable Long id) {
        return coachService.getRounds(id);
    }

    @GetMapping("/games")
    public Iterable<Game> getGames() {
        return coachService.getGames();
    }

    @PostMapping("/games")
    public Game createGame(@RequestBody Game game) {
        return coachService.createNewGame(game);
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        return ResponseEntity.of(coachService.getGame(id));
    }

}
