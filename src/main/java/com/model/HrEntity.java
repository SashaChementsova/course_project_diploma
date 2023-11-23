package com.model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HrEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHr;
    @OneToOne(mappedBy = "hrEntity", fetch = FetchType.LAZY)
    private UserDetailsEntity userDetailsEntity;

    @OneToMany(mappedBy = "hrEntity")
    private List<VacancyEntity> vacancyEntities;
}
