package com.repository;

import com.model.PositionTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionTestRepository extends JpaRepository<PositionTestEntity,Integer> {
}
