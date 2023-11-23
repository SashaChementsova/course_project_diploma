package com.model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InterviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInterview;
    @Column(nullable = false)
    private Timestamp dateAndTime;
    @Column(nullable = false)
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    private TrialEntity trialEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeeEntity employeeEntity;

    @OneToOne(mappedBy = "interviewEntity", fetch = FetchType.LAZY)
    private ResultEntity resultEntity;

}
