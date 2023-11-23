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
public class EducationTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducationType;
    @Column(nullable = false, unique = true)
    private String typeOfEducation;

    @OneToMany(mappedBy = "educationTypeEntity")
    private List<EducationEntity> educationEntities;
}
