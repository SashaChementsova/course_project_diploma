package com.repository;

import com.model.PositionNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionNameRepository extends JpaRepository<PositionNameEntity,Integer> {
}
