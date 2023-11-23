package com.repository;

import com.model.VacancyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<VacancyEntity,Integer> {
}
