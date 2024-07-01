package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_profiles")
public class UserProfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "website")
    private String website;

    @Column(name = "mother_tongue_id", nullable = false)
    private Integer motherTongueId;

    @Column(name = "religion_id", nullable = false)
    private Integer religionId;

    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "state_id", nullable = false)
    private Integer stateId;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Column(name = "height", nullable = false)
    private String height;

    @Column(name = "skin_tone", nullable = false)
    private String skinTone;

    @Column(name = "body_type", nullable = false)
    private String bodyType;

    @Column(name = "diet", nullable = false)
    private String diet;

    @Column(name = "smoke", nullable = false)
    private String smoke;

    @Column(name = "drink", nullable = false)
    private String drink;

    @Column(name = "own_words", nullable = false)
    private String ownWords;

    @Column(name = "disability", nullable = false)
    private String disability;

    @Column(name = "hiv_positive", nullable = false)
    private String hivPositive;

    @Column(name = "profile_complete", nullable = false)
    private Integer profileComplete;

}
