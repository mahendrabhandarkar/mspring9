package com.ks.mspring9.entity;

import com.ks.mspring9.entity.ids.UserAutologinId;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_autologin")
@IdClass(UserAutologinId.class)
public class UserAutologin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "key_id", nullable = false)
    private String keyId;

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_agent", nullable = false)
    private String userAgent;

    @Column(name = "last_ip", nullable = false)
    private String lastIp;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

}
