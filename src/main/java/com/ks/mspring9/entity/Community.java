package com.ks.mspring9.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
//@Table(schema = "public", name = "community", indexes = {@Index(columnList = "community_name")})
@Table(name = "community", indexes = {@Index(columnList = "community_name")})
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "religion_id", nullable = false)
    private Integer religionId;

    @Column(name = "community_name", nullable = false)
    private String communityName;
/*
    // mapped with property name in entity of sub-community
    @OneToMany(mappedBy = "communityId")
    @OrderBy("DESC")
    private Set<SubCommunity> subCommunities;
 */
}
