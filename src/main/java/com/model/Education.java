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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducation;
    @Column(nullable = false)
    private Date yearOfGraduation;

    @ManyToOne(fetch = FetchType.LAZY)
    private EducationType educationType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Candidate candidate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
}
