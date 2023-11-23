package com.repository;

import com.model.HrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrRepository extends JpaRepository<HrEntity,Integer> {
}
