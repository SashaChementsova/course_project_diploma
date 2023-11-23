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
public class ResultTestingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResultTesting;
    @OneToOne(mappedBy = "resultTestingEntity", fetch = FetchType.LAZY)
    private PositionTestEntity positionTestEntity;
    @OneToMany(mappedBy = "resultTestingEntity")
    private List<LanguageTestEntity> languageTestEntities;
}
