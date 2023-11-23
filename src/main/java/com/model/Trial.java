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
public class Trial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrial;
    @Column(nullable = false)
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Candidate candidate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vacancy vacancy;

    @OneToMany(mappedBy = "trial")
    private List<Interview> interviewEntities;


}
