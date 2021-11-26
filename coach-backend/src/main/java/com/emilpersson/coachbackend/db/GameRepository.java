package com.emilpersson.coachbackend.db;

import com.emilpersson.coachbackend.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
