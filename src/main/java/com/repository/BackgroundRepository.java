package com.repository;

import com.model.Background;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends JpaRepository<Background,Integer> {
}
