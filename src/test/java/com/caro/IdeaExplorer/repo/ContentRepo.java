package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Member;
import com.caro.IdeaExplorer.entity.Content;
import org.springframework.data.repository.CrudRepository;

public interface ContentRepo extends CrudRepository<Content, Long> {
    abstract String getContent();
    abstract void setContent(String text);

}
