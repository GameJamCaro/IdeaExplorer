package com.caro.IdeaExplorer.entity;

import com.caro.IdeaExplorer.repo.AuthorRepo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

/**
 * Entity for chat thread which contains different kinds of content (messages, prompts and api output).
 * Member is the observer
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Author implements AuthorRepo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    public Author(Long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public <S extends Author> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Author> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Author> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Author> findAll() {
        return null;
    }

    @Override
    public Iterable<Author> findAllById(Iterable<Integer> integers) {
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
    public void delete(Author entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Author> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
