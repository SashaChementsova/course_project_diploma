package com.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PositionTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPositionTest;
    //@Column(nullable = false)
    private Date date;
    @OneToOne(mappedBy = "positionTestEntity", fetch = FetchType.LAZY)
    private ResultEntity resultEntity;

    @OneToMany(mappedBy = "positionTestEntity")
    private List<PositionTestHasQuestionEntity> positionTestHasQuestionEntities;

    @OneToOne(fetch = FetchType.LAZY)
    private ResultTestingEntity resultTestingEntity;
}
