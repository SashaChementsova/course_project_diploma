package com.repository;

import com.model.BackgroundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackgroundRepository extends JpaRepository<BackgroundEntity,Integer> {
}
