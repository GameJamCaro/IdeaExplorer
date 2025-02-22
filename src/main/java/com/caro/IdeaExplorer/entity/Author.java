package com.caro.IdeaExplorer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity for chat thread which contains different kinds of content (messages, prompts and api output).
 * Member is the observer
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToOne
    private Content content;

    @ManyToOne
    private Thread thread;

    public Author(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
