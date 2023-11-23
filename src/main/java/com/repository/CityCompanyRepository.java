package com.repository;

import com.model.CityCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityCompanyRepository extends JpaRepository<CityCompanyEntity,Integer> {
}
