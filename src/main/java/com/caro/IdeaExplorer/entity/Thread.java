package com.caro.IdeaExplorer.entity;

import com.caro.IdeaExplorer.repo.ThreadRepo;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.*;


/**
 * Entity for chat thread which contains different kinds of content (messages, prompts and api output).
 * Thread is the observable
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
public class Thread  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true) // a thread contains different kinds of content (message, prompt or api output)
    private List<Content> contents = new ArrayList<>();

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Author> authors = new ArrayList<>();


    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }

    public void notifyAuthor(Author author) {
        // notify the author
    }

    public void addContent(Content content) {

    }

    public void removeContent(Content content) {

    };


}

