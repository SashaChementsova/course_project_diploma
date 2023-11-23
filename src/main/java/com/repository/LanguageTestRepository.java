package com.repository;

import com.model.LanguageTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTestRepository extends JpaRepository<LanguageTestEntity,Integer> {
}
