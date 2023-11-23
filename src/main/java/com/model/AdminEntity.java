package com.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;
    @Column(nullable = false,unique = true)
    private String nameCompany;
    @Column(nullable = false,unique = true)
    private String nameDirector;
    @OneToOne(fetch = FetchType.LAZY)
    private OrganizationalAndLegalFormEntity organizationalAndLegalForm;

    @OneToOne(fetch = FetchType.LAZY)     ///////////////////////////////////////////////////////////////
    private UserDetailsEntity userDetailsEntity;
}
