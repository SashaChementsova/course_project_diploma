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
public class LevelPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPositionLanguage;

    @Column(nullable=false, unique=true)
    private String level;
    @OneToMany(mappedBy = "levelPosition")
    private List<Position> positionEntities;
}
