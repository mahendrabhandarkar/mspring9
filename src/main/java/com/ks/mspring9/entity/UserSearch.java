package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_search")
public class UserSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "profile_img", nullable = false)
    private Integer profileImg;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Column(name = "religion_id", nullable = false)
    private Integer religionId;

    @Column(name = "mother_tongue_id", nullable = false)
    private Integer motherTongueId;

    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "state_id", nullable = false)
    private Integer stateId;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "edu_id", nullable = false)
    private Integer eduId;

    @Column(name = "diet", nullable = false)
    private String diet;

    @Column(name = "disability", nullable = false)
    private String disability;

    @Column(name = "hiv_positive", nullable = false)
    private String hivPositive;

}
