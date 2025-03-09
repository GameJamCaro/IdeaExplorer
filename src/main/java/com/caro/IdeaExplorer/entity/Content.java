package com.caro.IdeaExplorer.entity;

import com.caro.IdeaExplorer.repo.ContentRepo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Optional;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Content  {



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
    @JoinColumn(name = "thread_id")
    private Thread thread; // a thread contains different kinds of content (message, prompt or api output)

    public Content(Integer id, String content, Author author, ContentType type) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.type = type;
        this.creationTime = new Date();

    }


}
