package com.emilpersson.coachbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Round {

    @JsonProperty
    private Integer round;
    @JsonProperty
    private String shortDesc;
}

