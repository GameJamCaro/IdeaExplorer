package com.caro.IdeaExplorer.entity;

import com.caro.IdeaExplorer.repo.AuthorRepo;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

/**
 * Entity for chat thread which contains different kinds of content (messages, prompts and api output).
 * Member is the observer
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Author  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne // Many authors can be in one thread
    @JoinColumn(name = "thread_id")
    private Thread thread;

    public Author(Integer id, String name){
        this.id = id;
        this.name = name;
    }


}
