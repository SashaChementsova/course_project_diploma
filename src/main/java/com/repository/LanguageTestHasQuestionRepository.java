package com.repository;

import com.model.LanguageTestHasQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTestHasQuestionRepository extends JpaRepository<LanguageTestHasQuestionEntity,Integer> {
}
