package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "partner_lifestyle")
public class PartnerLifestyle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "pdiet", nullable = false)
    private String pdiet;

    @Column(name = "psmoke", nullable = false)
    private String psmoke;

    @Column(name = "pdrink", nullable = false)
    private String pdrink;

}
