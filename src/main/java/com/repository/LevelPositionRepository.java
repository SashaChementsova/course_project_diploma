package com.repository;

import com.model.LevelPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelPositionRepository extends JpaRepository<LevelPositionEntity,Integer> {
}
