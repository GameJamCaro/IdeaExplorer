package com.caro.IdeaExplorer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Class to represent a team of members who use the chat
 */
@NoArgsConstructor
@Getter
@Setter
@Entity // Spring JPA annotation: DB
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // unique id
    private String name; // name of the team




    public Team(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
