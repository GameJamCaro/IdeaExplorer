package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.entity.Content;
import com.caro.IdeaExplorer.entity.Thread;
import org.springframework.data.repository.CrudRepository;

public interface ThreadRepo extends CrudRepository<Thread, Integer> {
    void addAuthor(Author author);

    void removeAuthor(Author author);

    void notifyAuthor(Author author);

    void addContent(Content content);

    void removeContent(Content content);
}
