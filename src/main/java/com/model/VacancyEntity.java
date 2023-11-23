package com.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VacancyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVacancy;
    @Column(nullable = false)
    private int freePositions;
    @Column(nullable = false)
    private boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="VacancyHasLanguagesEntity",
            joinColumns={@JoinColumn(name="VACANCY_ID", referencedColumnName="idVacancy")},
            inverseJoinColumns={@JoinColumn(name="LANGUAGE_ID", referencedColumnName="idLanguage")})
    private List<LanguageEntity> languages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private PositionEntity positionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private CityCompanyEntity cityCompanyEntity;

    @OneToOne(mappedBy = "vacancyEntity", fetch = FetchType.LAZY)
    private BackgroundEntity backgroundEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private HrEntity hrEntity;

    @OneToMany(mappedBy = "vacancyEntity")
    private List<TrialEntity> trialEntities;


}
