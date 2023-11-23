package com.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAddressCompany;
    @Column(nullable = false)
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    private CityCompany cityCompany;
}
