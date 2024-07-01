package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_background")
public class UserBackground implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "religion_id", nullable = false)
    private Integer religionId;

    @Column(name = "community_id", nullable = false)
    private Integer communityId;

    @Column(name = "sub_community", nullable = false)
    private String subCommunity;

    @Column(name = "bcomplete", nullable = false)
    private Integer bcomplete;

}
