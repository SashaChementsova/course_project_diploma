package com.repository;

import com.model.EducationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationTypeEntity,Integer> {
}
