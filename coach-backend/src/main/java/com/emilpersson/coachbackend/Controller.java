package com.emilpersson.coachbackend;

import com.emilpersson.coachbackend.db.GameRepository;
import com.emilpersson.coachbackend.db.RoundRepository;
import com.emilpersson.coachbackend.model.Game;
import com.emilpersson.coachbackend.model.Round;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class Controller {

    private final RoundRepository roundRepository;
    private final GameRepository gameRepository;

    public Controller(RoundRepository roundRepository, GameRepository gameRepository) {
        this.roundRepository = roundRepository;
        this.gameRepository = gameRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Round> addRound(@RequestBody Round round) {
        return ResponseEntity.ok(this.roundRepository.save(round));
    }

    @GetMapping("/rounds")
    public ResponseEntity<List<Round>> getRounds() {
        return ResponseEntity.ok(this.roundRepository.findAll());
    }

    @GetMapping("/round/{id}")
    public ResponseEntity getRound(@PathVariable final Integer id) {
        var round = this.roundRepository.findById(id);

        if(round.isPresent()) {
            return ResponseEntity.ok(round.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/game")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        var newGame = Game.builder()
                .map(game.getMap())
                .date(Date.from(Instant.now()))
                .build();
        return ResponseEntity.ok(this.gameRepository.save(newGame));
    }


}
