package com.caro.IdeaExplorer.repo;

import com.caro.IdeaExplorer.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepo extends CrudRepository<Member, Long> {
}
