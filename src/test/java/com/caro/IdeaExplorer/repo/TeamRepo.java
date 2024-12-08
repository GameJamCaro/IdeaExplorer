package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepo extends CrudRepository<Team, Long> {
}
