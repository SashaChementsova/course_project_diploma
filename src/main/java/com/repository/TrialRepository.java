package com.repository;

import com.model.TrialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrialRepository extends JpaRepository<TrialEntity,Integer> {
}
