package com.emilpersson.coachbackend.db;

import com.emilpersson.coachbackend.model.Round;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoundRepository extends CrudRepository<Round, Integer> {
    List<Round> findAll();
}