package com.repository;

import com.model.TrialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialRepository extends JpaRepository<TrialEntity,Integer> {
}
