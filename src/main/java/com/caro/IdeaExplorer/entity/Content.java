package com.caro.IdeaExplorer.entity;

import com.caro.IdeaExplorer.repo.ContentRepo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content implements ContentRepo {
    @Override
    public <S extends Content> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Content> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Content> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Content> findAll() {
        return null;
    }

    @Override
    public Iterable<Content> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Content entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Content> entities) {

    }

    @Override
    public void deleteAll() {

    }

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
