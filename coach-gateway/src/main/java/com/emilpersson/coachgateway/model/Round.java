package com.emilpersson.coachgateway.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Round {

    private Integer round;
    private String shortDesc;
}
