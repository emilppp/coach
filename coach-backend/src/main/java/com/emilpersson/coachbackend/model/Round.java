package com.emilpersson.coachbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "rounds")
public class Round implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @JsonProperty
    private Integer round;
    @JsonProperty
    private String shortDesc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "round_id", nullable = false)
    private Game game;

    public Round() {

    }

    public Round(Integer round, String shortDesc, Game game) {
        this.round = round;
        this.shortDesc = shortDesc;
        this.game = game;
    }

    public Round(Integer id, Integer round, String shortDesc, Game game) {
        this.Id = id;
        this.round = round;
        this.shortDesc = shortDesc;
        this.game = game;
    }

}

