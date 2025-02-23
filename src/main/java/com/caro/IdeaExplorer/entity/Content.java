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
    private Integer id;
    private String text;
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private ContentType type;
    private Date creationTime;

    @ManyToOne
    private Thread thread; // a thread contains different kinds of content (message, prompt or api output)

    public Content(Integer id, String content, Author author, ContentType type) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.type = type;
        this.creationTime = new Date();
    }
}
