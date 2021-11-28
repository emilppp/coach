package com.emilpersson.coachbackend.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Game {

    @org.springframework.data.annotation.Id
    private Long id;
    @JsonProperty
    private String map;
    private List<Round> rounds;
    private LocalDate date;


    public Game(Long id, String map, List<Round> rounds, LocalDate date) {
        this.id = id;
        this.map = map;
        this.rounds = rounds;
        this.date = date;
    }

    public void addRound(Round round) {
        this.rounds.add(round);
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
