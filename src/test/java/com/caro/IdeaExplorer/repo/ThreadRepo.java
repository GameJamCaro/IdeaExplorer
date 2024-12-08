package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Thread;
import org.springframework.data.repository.CrudRepository;

public interface ThreadRepo extends CrudRepository<Thread, Long> {
}
