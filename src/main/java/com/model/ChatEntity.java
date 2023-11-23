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
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChat;
    @Column(nullable = false)
    private Date dateOfCreation;
    @OneToMany(mappedBy = "chatEntity")
    private List<MessageEntity> messageEntities;
    @ManyToMany(mappedBy="chats")
    private List<UserDetailsEntity> userDetailsEntities;

}
