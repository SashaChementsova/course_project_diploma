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
public class LanguageTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLanguageTest;
    //@Column(nullable = false)
    private Date date;
    @OneToOne(mappedBy = "languageTestEntity", fetch = FetchType.LAZY)
    private ResultEntity resultEntity;

    @OneToMany(mappedBy = "languageTestEntity")
    private List<LanguageTestHasQuestionEntity> languageTestHasQuestionEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    private ResultTestingEntity resultTestingEntity;

}
