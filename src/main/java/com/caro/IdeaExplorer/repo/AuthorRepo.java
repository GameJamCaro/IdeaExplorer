package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Integer> {
}
