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
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLanguage;
    @ManyToOne(fetch = FetchType.LAZY)
    private LevelLanguageEntity levelLanguage;
    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageNameEntity languageName;

    @ManyToMany(mappedBy="languages")
    private List<CandidateEntity> candidateEntities;

    @ManyToMany(mappedBy="languages")
    private List<EmployeeEntity> employeeEntities;

    @ManyToMany(mappedBy="languages")
    private List<VacancyEntity> vacancyEntities;
    @OneToMany(mappedBy = "languageEntity")
    private List<LanguageTestQuestionEntity> languageTestQuestionEntities;
}
