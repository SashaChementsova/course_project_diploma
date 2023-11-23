package com.model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    @Column(nullable = false)
    private Timestamp dateAndTime;
    @Column(nullable=false)
    private String messageText;
    @Column(nullable = false)
    private int idSender;
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatEntity chatEntity;

}
