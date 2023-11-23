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
public class LevelPositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPositionLanguage;

    @Column(nullable=false, unique=true)
    private String level;
    @OneToMany(mappedBy = "positionLanguage")
    private List<PositionEntity> positionEntities;
}
