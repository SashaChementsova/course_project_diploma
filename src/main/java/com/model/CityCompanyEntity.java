package com.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CityCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCityCompany;

    @Column(nullable=false, unique=true)
    private String nameCity;

    @OneToMany(mappedBy = "cityCompanyEntity")
    private List<AddressCompanyEntity> addressCompanyEntities;

    @OneToMany(mappedBy = "cityCompanyEntity")
    private List<EmployeeEntity> employeeEntities;

    @OneToMany(mappedBy = "cityCompanyEntity")
    private List<VacancyEntity> vacancyEntities;
}
