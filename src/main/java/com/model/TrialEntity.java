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
public class TrialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrial;
    @Column(nullable = false)
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private CandidateEntity candidateEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private VacancyEntity vacancyEntity;

    @OneToMany(mappedBy = "trialEntity")
    private List<InterviewEntity> interviewEntities;


}
