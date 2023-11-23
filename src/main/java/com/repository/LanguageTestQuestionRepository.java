package com.repository;

import com.model.LanguageTestQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTestQuestionRepository extends JpaRepository<LanguageTestQuestionEntity,Integer> {
}
