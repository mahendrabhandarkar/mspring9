package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "user_family")
public class UserFamily implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "father_name", nullable = false)
    private String fatherName;

    @Column(name = "mother_name", nullable = false)
    private String motherName;

    @Column(name = "father_status", nullable = false)
    private String fatherStatus;

    @Column(name = "mother_status", nullable = false)
    private String motherStatus;

    @Column(name = "family_status", nullable = false)
    private String familyStatus;

    @Column(name = "brother", nullable = false)
    private Integer brother;

    @Column(name = "sister", nullable = false)
    private Integer sister;

}
