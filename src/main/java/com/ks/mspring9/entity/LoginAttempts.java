package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "login_attempts")
public class LoginAttempts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;

}
