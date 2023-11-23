package com.repository;

import com.model.PositionTestHasQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionTestHasQuestionRepository extends JpaRepository<PositionTestHasQuestionEntity,Integer> {
}
