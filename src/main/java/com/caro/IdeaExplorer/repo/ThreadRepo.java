package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Author;
import com.caro.IdeaExplorer.entity.Content;
import com.caro.IdeaExplorer.entity.Thread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ThreadRepo extends CrudRepository<Thread, Integer> {

}
