package com.caro.IdeaExplorer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Author author;
    private Date creationTime;

    @ManyToOne
    private Thread thread; // a thread contains different kinds of content (message, prompt or api output)

    public Content(Long id, String content, Author author){
        this.id = id;
        this.text = text;
        this.author = author;
    }
}
