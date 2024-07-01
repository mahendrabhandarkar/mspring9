package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "account_setting")
public class AccountSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "display_mobile", nullable = false)
    private Integer displayMobile;

    @Column(name = "display_email", nullable = false)
    private Integer displayEmail;

    @Column(name = "display_profile", nullable = false)
    private Integer displayProfile;

}
