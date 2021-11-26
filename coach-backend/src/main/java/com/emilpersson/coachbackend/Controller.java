package com.emilpersson.coachbackend;

import com.emilpersson.coachbackend.db.GameRepository;
import com.emilpersson.coachbackend.model.Game;
import com.emilpersson.coachbackend.model.Round;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.Optional;

@RestController
public class Controller {

    private final GameRepository gameRepository;

    public Controller(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping("/{id}/add")
    public Round addRound(@RequestBody Round round, @PathVariable Long id) {
        Optional<Game> game = gameRepository.findById(id);
        game.get().addRound(round);
        gameRepository.save(game.get());
        return round;

    }

    @GetMapping("/{id}/rounds")
    public List<Round> getRounds(@PathVariable Long id) {
        Game game = gameRepository.findById(id).get();
        return game.getRounds();
    }


    @PostMapping("/game")
    public Game createGame(@RequestBody Game game) {
        var newGame = new Game(null, game.getMap(), null, LocalDate.now());
        
        return gameRepository.save(newGame);

    }

    @GetMapping("/game/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameRepository.findById(id).get();
    }


}
