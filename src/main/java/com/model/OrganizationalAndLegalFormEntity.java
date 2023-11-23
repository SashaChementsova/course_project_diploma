package com.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrganizationalAndLegalFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrganizationalAndLegalForm;
    @Column(nullable = false, unique = true)
    private String shortName;
    @Column(nullable = false, unique = true)
    private String longName;
    @OneToOne(fetch = FetchType.LAZY)
    private AdminEntity adminEntity;
}
