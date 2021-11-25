package com.emilpersson.coachbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@Entity
@Table
public class Game implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String map;
    private Date date;
    @OneToMany(mappedBy="game", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Round> rounds;

    public Game() {

    }

    public Game(String map) {
        this.map = map;
    }

    public Game(Integer id, String map, Date date, Set<Round> rounds) {
        this.Id = id;
        this.map = map;
        this.date = date;
        this.rounds = rounds;
    }

    //private Team teamOne;
   // private Team teamTwo;

}
