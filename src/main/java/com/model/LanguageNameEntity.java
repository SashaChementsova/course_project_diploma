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
public class LanguageNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLanguageName;

    @Column(nullable=false, unique=true)
    private String name;

    @OneToMany(mappedBy = "languageName")
    private List<LanguageEntity> languageEntities;
}
