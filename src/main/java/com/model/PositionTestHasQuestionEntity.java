package com.model;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PositionTestHasQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPositionTestHasQuestion;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private PositionTestEntity positionTestEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private PositionTestQuestionEntity positionTestQuestionEntity;
}
