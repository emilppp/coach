package com.emilpersson.coachbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Round {

    @JsonProperty
    private Integer round;
    @JsonProperty
    private String description;

    public Round(Integer round, String description) {
        this.round = round;
        this.description = description;
    }
}

