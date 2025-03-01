package com.caro.IdeaExplorer.entity;

import com.caro.IdeaExplorer.repo.ThreadRepo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.util.Optional;


/**
 * Entity for chat thread which contains different kinds of content (messages, prompts and api output).
 * Thread is the observable
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Thread implements ThreadRepo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToOne  // a thread contains different kinds of content (message, prompt or api output)
    private Content content;

    @ManyToOne // a thread contains different authors
    private Author author;


    @Override
    public void addAuthor(Author author) {

    }

    @Override
    public void removeAuthor(Author author) {

    }

    @Override
    public void notifyAuthor(Author author) {

    }

    @Override
    public void addContent(Content content) {
        
    }

    @Override
    public void removeContent(Content content) {

    }

    @Override
    public <S extends Thread> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Thread> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Thread> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Thread> findAll() {
        return null;
    }

    @Override
    public Iterable<Thread> findAllById(Iterable<Integer> integers) {
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
    public void delete(Thread entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Thread> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

