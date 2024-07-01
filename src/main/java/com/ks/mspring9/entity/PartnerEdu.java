package com.ks.mspring9.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "partner_edu")
public class PartnerEdu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "pedu_level_id", nullable = false)
    private Integer peduLevelId;

    @Column(name = "pedu_field_id", nullable = false)
    private Integer peduFieldId;

    @Column(name = "pwork_with_id", nullable = false)
    private Integer pworkWithId;

    @Column(name = "pwork_as_id", nullable = false)
    private Integer pworkAsId;

    @Column(name = "pannual_income", nullable = false)
    private Integer pannualIncome;

}
