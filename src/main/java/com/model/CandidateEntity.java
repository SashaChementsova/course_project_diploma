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
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCandidate;

    @OneToOne(fetch = FetchType.LAZY)
    private UserDetailsEntity userDetailsEntity;

    @OneToOne(mappedBy = "candidateEntity", fetch = FetchType.LAZY)
    private BackgroundEntity backgroundEntity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="CandidateHasLanguagesEntity",
            joinColumns={@JoinColumn(name="CANDIDATE_ID", referencedColumnName="idCandidate")},
            inverseJoinColumns={@JoinColumn(name="LANGUAGE_ID", referencedColumnName="idLanguage")})
    private List<LanguageEntity> languages = new ArrayList<>();

    @OneToMany(mappedBy = "candidateEntity")
    private List<EducationEntity> educationEntities;

    @OneToMany(mappedBy = "candidateEntity")
    private List<TrialEntity> trialEntities;
}
