package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "message_inbox")
public class MessageInbox implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "from_to", nullable = false)
    private Integer fromTo;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "view", nullable = false)
    private Integer view;

    @Column(name = "message", nullable = false)
    private String message;

}
