package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "partner_background")
public class PartnerBackground implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "preligion_id", nullable = false)
    private Integer preligionId;

    @Column(name = "pcommunity_id", nullable = false)
    private Integer pcommunityId;

    @Column(name = "psub_community", nullable = false)
    private String psubCommunity;

}
