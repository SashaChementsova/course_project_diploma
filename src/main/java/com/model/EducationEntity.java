package com.model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducation;
    @Column(nullable = false)
    private Date yearOfGraduation;

    @ManyToOne(fetch = FetchType.LAZY)
    private EducationTypeEntity educationTypeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private CandidateEntity candidateEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeeEntity employeeEntity;
}
