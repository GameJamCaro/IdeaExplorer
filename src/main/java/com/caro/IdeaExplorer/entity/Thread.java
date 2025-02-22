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

    @ManyToOne  // a thread contains different kinds of content (message, prompt or api output)
    private Content content;

    @ManyToOne // a thread contains different authors
    private Author author;

    void addContent(Content content) {
        // add content to thread
    }

    void deleteContent(Content content) {
        // delete content from thread
    }

    void addAuthor(Author author) {
        // add author to thread
    }

    void deleteAuthor(Author author) {
        // delete author from thread
    }

    void notifyAuthors() {
        // notify authors of thread
    }
}

