package com.repository;

import com.model.ResultTestingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultTestingRepository extends JpaRepository<ResultTestingEntity,Integer> {
}
