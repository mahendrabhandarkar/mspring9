package com.ks.mspring9.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "user_edu")
public class UserEdu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "edu_level_id", nullable = false)
    private Integer eduLevelId;

    @Column(name = "edu_field_id", nullable = false)
    private Integer eduFieldId;

    @Column(name = "work_with_id", nullable = false)
    private Integer workWithId;

    @Column(name = "work_as_id", nullable = false)
    private Integer workAsId;

    @Column(name = "annual_income", nullable = false)
    private Integer annualIncome;

}
