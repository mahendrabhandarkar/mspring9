package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile_no", nullable = false)
    private String mobileNo;

    @Column(name = "profile_for", nullable = false)
    private String profileFor;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "activated", nullable = false)
    private Boolean activated;

    @Column(name = "banned", nullable = false)
    private Boolean banned;

    @Column(name = "ban_reason")
    private String banReason;

    @Column(name = "new_password_key")
    private String newPasswordKey;

    @Column(name = "new_password_requested")
    private LocalDateTime newPasswordRequested;

    @Column(name = "new_email")
    private String newEmail;

    @Column(name = "new_email_key")
    private String newEmailKey;

    @Column(name = "last_ip", nullable = false)
    private String lastIp;

    @Column(name = "last_login", nullable = false)
    private LocalDateTime lastLogin;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @Column(name = "modified", nullable = false)
    private LocalDateTime modified;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

}
