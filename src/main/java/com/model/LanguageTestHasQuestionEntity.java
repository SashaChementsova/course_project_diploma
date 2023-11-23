package com.model;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LanguageTestHasQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLanguageTestHasQuestionEntity;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageTestEntity languageTestEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private LanguageTestQuestionEntity languageTestQuestionEntity;
}
