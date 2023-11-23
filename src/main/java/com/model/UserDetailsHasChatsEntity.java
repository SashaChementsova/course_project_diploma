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
public class UserDetailsHasChatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserDetailsHasChats;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserDetailsEntity userDetailsEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatEntity chatEntity;
}
