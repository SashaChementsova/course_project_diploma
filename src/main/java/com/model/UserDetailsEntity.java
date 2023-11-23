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
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserDetails;
    @Column(nullable=false)
    private String name;
    private String patronymic;
    @Column(nullable=false)
    private String surname;
    @Column(nullable=false, unique=true)
    private String phone;
    @Column(nullable=false)
    private Date birthday;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    private String info;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="UserDetailsHasRoleEntity",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="idUserDetails")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="idRole")})
    private List<RoleEntity> roles = new ArrayList<>();

    @OneToOne(mappedBy = "userDetailsEntity", fetch = FetchType.LAZY)
    private AdminEntity adminEntity;

    @OneToOne(mappedBy = "userDetailsEntity", fetch = FetchType.LAZY)
    private HrEntity hrEntity;


    @OneToOne(mappedBy = "userDetailsEntity", fetch = FetchType.LAZY)
    private CandidateEntity candidateEntity;

    @OneToOne(mappedBy = "userDetailsEntity", fetch = FetchType.LAZY)
    private EmployeeEntity employeeEntity;

    @OneToMany(mappedBy = "userDetailsEntity")
    private List<UserDetailsHasChatsEntity> userDetailsHasChatsEntities;

    @OneToOne(mappedBy = "userDetailsEntity", fetch = FetchType.LAZY)
    private ImageEntity imageEntity;
}
