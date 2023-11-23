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
public class BackgroundEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBackground;

    @Column(nullable=false)
    private int experience;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="BackgroundHasSkillsEntity",
            joinColumns={@JoinColumn(name="BACKGROUND_ID", referencedColumnName="idBackground")},
            inverseJoinColumns={@JoinColumn(name="SKILL_ID", referencedColumnName="idSkill")})
    private List<SkillEntity> skills = new ArrayList<>();

    @OneToOne(mappedBy = "backgroundEntity",fetch = FetchType.LAZY)
    private CandidateEntity candidateEntity;

    @OneToOne(mappedBy = "backgroundEntity",fetch = FetchType.LAZY)
    private EmployeeEntity employeeEntity;

    @OneToOne(mappedBy = "backgroundEntity",fetch = FetchType.LAZY)
    private VacancyEntity vacancyEntity;

}
