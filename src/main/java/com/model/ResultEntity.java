package com.model;
import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResult;
    //@Column(nullable = false)
    private float points;
    //@Column(nullable = false)
    private String feedback;

    @OneToOne(mappedBy = "resultEntity",fetch = FetchType.LAZY)
    private InterviewEntity interviewEntity;
    @OneToOne(fetch = FetchType.LAZY)
    private PositionTestEntity positionTestEntity;

    @OneToOne(mappedBy = "resultEntity",fetch = FetchType.LAZY)
    private LanguageTestEntity languageTestEntity;
}
