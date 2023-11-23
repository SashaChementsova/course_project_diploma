package com.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;

    @Column(nullable = false)
    private Date dateRecruitment;
    @Column(nullable = false)
    private Date dateContractEnd;

    @OneToOne(fetch = FetchType.LAZY)
    private UserDetailsEntity userDetailsEntity;

    @OneToOne(mappedBy = "employeeEntity", fetch = FetchType.LAZY)
    private BackgroundEntity backgroundEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="EmployeeHasLanguagesEntity",
            joinColumns={@JoinColumn(name="EMPLOYEE_ID", referencedColumnName="idEmployee")},
            inverseJoinColumns={@JoinColumn(name="LANGUAGE_ID", referencedColumnName="idLanguage")})
    private List<LanguageEntity> languages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private PositionEntity positionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private CityCompanyEntity cityCompanyEntity;

    @OneToMany(mappedBy = "employeeEntity")
    private List<EducationEntity> educationEntities;

    @OneToMany(mappedBy = "employeeEntity")
    private List<InterviewEntity> interviewEntities;

}
