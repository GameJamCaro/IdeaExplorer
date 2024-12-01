package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.chat.Author;
import com.caro.IdeaExplorer.chat.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends CrudRepository<Content, Long> {
    abstract String getContent();
    abstract void setContent(String content);
    abstract Author getAuthor();
    abstract void setAuthor();
}
