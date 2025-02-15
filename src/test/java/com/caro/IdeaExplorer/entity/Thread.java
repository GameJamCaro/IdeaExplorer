package com.caro.IdeaExplorer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;


/**
 * Entity for chat thread which contains different kinds of content (messages, prompts and api output).
 * Thread is the observable
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;




    void addAuthor(Author author) {
        // add author to thread




    }
}

