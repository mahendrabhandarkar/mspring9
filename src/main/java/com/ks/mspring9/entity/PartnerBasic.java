package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "partner_basic")
public class PartnerBasic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "pcountry_id", nullable = false)
    private Integer pcountryId;

    @Column(name = "pstate_id", nullable = false)
    private Integer pstateId;

    @Column(name = "pcity_id", nullable = false)
    private Integer pcityId;

    @Column(name = "pmtongue_id", nullable = false)
    private Integer pmtongueId;

    @Column(name = "pmarital_status", nullable = false)
    private String pmaritalStatus;

    @Column(name = "page", nullable = false)
    private Integer page;

    @Column(name = "pageto", nullable = false)
    private Integer pageto;

    @Column(name = "pheightto", nullable = false)
    private Integer pheightto;

    @Column(name = "pheight", nullable = false)
    private Integer pheight;

    @Column(name = "pskin_tone", nullable = false)
    private String pskinTone;

    @Column(name = "pbody_type", nullable = false)
    private String pbodyType;

    @Column(name = "pdisability", nullable = false)
    private String pdisability;

    @Column(name = "phiv_positive", nullable = false)
    private String phivPositive;

    @Column(name = "pprofile_complete", nullable = false)
    private Integer pprofileComplete;

}
