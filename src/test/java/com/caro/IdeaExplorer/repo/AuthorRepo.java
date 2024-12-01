package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.chat.Author;
import com.caro.IdeaExplorer.chat.User;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
