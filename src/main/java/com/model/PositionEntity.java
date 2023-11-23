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
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPosition;
    @ManyToOne(fetch = FetchType.LAZY)
    private LevelPositionEntity levelPosition;
    @ManyToOne(fetch = FetchType.LAZY)
    private PositionNameEntity positionName;

    @OneToMany(mappedBy = "positionEntity")
    private List<EmployeeEntity> employeeEntities;

    @OneToMany(mappedBy = "positionEntity")
    private List<VacancyEntity> vacancyEntities;

    @OneToMany(mappedBy = "positionEntity")
    private List<PositionTestQuestionEntity> positionTestQuestionEntities;
}
